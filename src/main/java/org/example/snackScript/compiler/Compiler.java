package org.example.snackScript.compiler;

import lombok.RequiredArgsConstructor;
import org.example.snackScript.SnackScript;
import org.example.snackScript.ast.*;
import org.example.snackScript.vm.Blob;
import org.example.snackScript.vm.Function;
import org.example.snackScript.vm.Instruction;
import org.example.snackScript.vm.UpvalueMapEntry;

import java.util.IdentityHashMap;
import java.util.List;

import static org.example.snackScript.vm.Instruction.Code.*;

@RequiredArgsConstructor
public class Compiler {
    /* This class should not emit errors.  */
    private final SnackScript snackScript;

    private InTranslationBlob blob = null;

    private int emit(Instruction insn) {
        return blob.getCode().addInsn(insn);
    }

    private record IPInsn(int ip, Instruction insn) {
    }

    private IPInsn emit(Instruction.Code code) {
        Instruction insn = new Instruction(code);
        emit(insn);
        return new IPInsn(ip() - 1, insn);
    }

    private IPInsn emit(Instruction.Code opcode, int arg1) {
        Instruction insn = new Instruction(opcode, arg1);
        emit(insn);
        return new IPInsn(ip() - 1, insn);
    }

    private int ip() {
        return blob.getCode().code().size();
    }

    private void backPatch(IPInsn insn) {
        backpatch(insn, ip());
    }

    private void backpatch(IPInsn insn, int to) {
        assert (List.of(JUMP, JUMP_TRUE, JUMP_FALSE).contains(insn.insn.getOpcode()));
        var relIp = jumpOffset(to, insn.ip);
        insn.insn.setArg1(relIp);
    }

    private int jumpOffset(int to) {
        return jumpOffset(to, ip());
    }

    private int jumpOffset(int to, int from) {
        return to - (from + 1);
    }

    public Blob compileInput(StatementList input) {
        assert !(snackScript.hadError() || snackScript.hadRuntimeError());
        /* This function should only be called for the global scope.  */
        assert blob == null;
        var outerBlob = new InTranslationBlob(new Blob(),
                null,
                null,
                blob);
        /* Push.  */
        blob = outerBlob;

        compileBlock(input);
        /* Used as a signal to our VM that we're done with the blob.  */
        emit(FINISH_OUTER);

        /* We must've come back down to the bottom of the stack.  */
        assert blob == outerBlob;
        blob = null;

        /* There can't possibly be any locals here.  */
        assert outerBlob.getMaxLocalDepth() == 0;
        return outerBlob.getCode();
    }

    private void compileBlock(StatementList input) {
        var currentBlob = blob;
        var oldLocalDepth = currentBlob.getLocalDepth();

        for (var statement : input.getStmts())
            compileStatement(statement);

        blob.setLocalDepth(oldLocalDepth);
        assert currentBlob == blob;
    }

    private void compileBlock(Block input) {
        var currentBlob = blob;
        var oldLocalDepth = currentBlob.getLocalDepth();

        for (var statement : input.getBody())
            compileStatement(statement);

        blob.setLocalDepth(oldLocalDepth);
        assert currentBlob == blob;
    }

    private Instruction declareVariable(Declaration declaration) {
        if (blob.getPreviousBlob() == null) {
            /* New global variable.  */
            return new Instruction(SET_GLOBAL, snackScript.declareGlobal(declaration));
        } else {
            var newVarId = blob.getLocalDepth();
            blob.setLocalDepth(newVarId + 1);
            var oldId = blob.getLocalSlots().put(declaration, newVarId);
            assert oldId == null : "how did you redeclare it??";
            return new Instruction(SET_LOCAL, newVarId);
        }
    }


    private int compileFunction(FunctionStmt fn) {
        var function = new Function();
        function.setFuncDecl(fn);

        /* Push a new in-translation blob, suspending the translation of the
           previous one.  */
        var functionBlob = new InTranslationBlob(new Blob(),
                new IdentityHashMap<>(),
                new IdentityHashMap<>(),
                blob);
        blob = functionBlob;
        var newFnId = snackScript.addFunction(function);

        /* Declare function arguments into the first few slots.  We do this
           because the VM will, in response to CALL, place the arguments it
           reads off of the argument stack into the first local slots.  */
        fn.getParameters().forEach(this::declareVariable);

        /* Compile body as a usual block.  We've set up the compiler state so
           that the code the compiler emits while translating this function
           ends up in the new function.  */
        compileBlock(fn.getBody());

        emit(RETURN_VOID);

        /* Populate the function data.  */
        function.setCode(functionBlob.getCode());
        function.setLocalCount(functionBlob.getMaxLocalDepth());

        /* Set up the upvalue map.  */
        var upvals = new UpvalueMapEntry[functionBlob.getUpvalSlots().size()];
        function.setUpvalueMap(upvals);
        functionBlob.getUpvalSlots()
                .values()
                /* The function blob contains a mapping from declarations to the
                   slots they are in.  This time, we only care about the slots.
                   For each of those slots. set it up in the new upvalue map using
                   the upvalue reference we computed earlier.  */
                .forEach(s -> {
                    upvals[s.slotNr()] = s.entry();
                });

        /* Pop.  */
        blob = blob.getPreviousBlob();
        return newFnId;
    }


    private Instruction findLocalInsn(InTranslationBlob blob,
                                      Declaration decl) {
        /* We already checked globals in getVarInsn.  */
        var locals = blob.getLocalSlots();
        var upvals = blob.getUpvalSlots();
        assert locals != null && upvals != null;

        var local = locals.get(decl);
        if (local != null)
            return new Instruction(GET_LOCAL, local);

        /* So, this is a upvalue.  But is it new?  */
        var upval = blob.getUpvalSlots().get(decl);
        if (upval != null)
            /* No, it isn't.  */
            return new Instruction(GET_UPVALUE, upval.slotNr());

        /* It is.  */
        var inSuperscope = findLocalInsn(blob.getPreviousBlob(), decl);
        var upvalSlot = blob.getUpvalSlots().size();

        var upvalME = new UpvalueMapEntry(switch (inSuperscope.getOpcode()) {
            case GET_LOCAL -> UpvalueMapEntry.UpvalueLocation.LOCAL;
            case GET_UPVALUE -> UpvalueMapEntry.UpvalueLocation.UPVALUE;
            default -> throw new IllegalArgumentException();
        }, Math.toIntExact(inSuperscope.getArg1()));

        var oldSlot = blob.getUpvalSlots()
                .put(decl, new InTranslationBlob.UpvalSlotInfo(upvalSlot, upvalME));
        assert oldSlot == null;
        return new Instruction(GET_UPVALUE, upvalSlot);
    }


    private Instruction getVarInsn(Declaration decl) {
        return snackScript.getGlobalSlot(decl)
                .map(s -> new Instruction(GET_GLOBAL, s))
                .orElseGet(() -> findLocalInsn(blob, decl));
    }


    private void compileStatement(Statement stmt) {
        switch (stmt) {
            case ExprStmt es -> {
                compileExpr(es.getExpr());
                emit(POP);
            }

            case PrintStmt print -> {
            /* The VM contains a {@code PRINT} instruction that prints a single
               operand from the operand stack, however our language contains a
               n-ary {@code print} statement.  We must, then, implement the
               {@code print} statement as many {@code PRINT}s.  */
                print.getArgs().forEach
                        (expr -> {
                            compileExpr(expr);
                            emit(PRINT);
                        });
            }

            case InputStmt inputStatement -> {
            }

            case ReturnStmt ret -> {
                if (ret.getValue() != null) {
                    compileExpr(ret.getValue());
                    emit(RETURN);
                } else
                    emit(RETURN_VOID);
            }

            case FunctionStmt fn -> {
                var newVarSetter = declareVariable(fn);
                var fnId = compileFunction(fn);
                emit(BUILD_CLOSURE, fnId);
                emit(newVarSetter);
            }

            case Declaration decl -> {
                var newVarSetter = declareVariable(decl);
                compileExpr(decl.getValue());
                emit(newVarSetter);
            }


            case Assign assign -> {
                if (assign.getName() instanceof ArrayAccess arrayAccess) {
                    Instruction arrayVarInsn = getVarInsn(assign.getDeclaration());
                    emit(arrayVarInsn);

                    for (Expr index : arrayAccess.getIndexes()) {
                        compileExpr(index);
                    }

                    compileExpr(assign.getValue());

                    emit(ARRAY_ASSIGN);
                } else {
                    Instruction varInsn = getVarInsn(assign.getDeclaration());
                    compileExpr(assign.getValue());

                    switch (varInsn.getOpcode()) {
                        case GET_GLOBAL -> emit(SET_GLOBAL, varInsn.getArg1());
                        case GET_LOCAL -> emit(SET_LOCAL, varInsn.getArg1());
                        default -> throw new IllegalArgumentException();
                    }
                }
            }


            case IfStmt ifBranch -> {
                for (Expr condition : ifBranch.getConditions()) {
                    compileExpr(condition);
                }

                if (ifBranch.getElseBody() != null) {
                    var jumpElse = emit(JUMP_FALSE, Integer.MAX_VALUE);
                    emit(POP);

                    compileBlock(ifBranch.getIfBody());

                    var jumpIfEnd = emit(JUMP, Integer.MAX_VALUE);
                    backPatch(jumpElse);

                    compileBlock(ifBranch.getElseBody());
                    backPatch(jumpIfEnd);
                } else {
                    var jumpIfEnd = emit(JUMP_FALSE, Integer.MAX_VALUE);
                    emit(POP);

                    compileBlock(ifBranch.getIfBody());
                    backPatch(jumpIfEnd);
                }
            }

            case ForStmt forLoop -> {

                compileStatement(forLoop.getInitializer());

                var startOfLoop = ip();

                compileExpr(forLoop.getCondition());
                var exitJump = emit(JUMP_FALSE, Integer.MAX_VALUE);

                emit(POP);

                compileBlock(forLoop.getBody());

                if (forLoop.getUpdater() != null) {
                    compileExpr(forLoop.getUpdater());
                }

                emit(JUMP, jumpOffset(startOfLoop));

                backPatch(exitJump);

                emit(POP);
            }


            case WhileStmt whileLoop -> {
                var startOfLoop = ip();

                for (Expr condition : whileLoop.getConditions()) {
                    compileExpr(condition);
                }

                var exitJump = emit(JUMP_FALSE, Integer.MAX_VALUE);
                emit(POP);

                compileBlock(whileLoop.getBody());

                emit(JUMP, jumpOffset(startOfLoop));

                backPatch(exitJump);

                emit(POP);

            }
            case StatementList block -> compileBlock(block);

            default -> throw new IllegalStateException("Unexpected value: " + stmt);
        }
    }


    private void compileExpr(Expr expr) {
        switch (expr) {
            case ErrorExpr ignored -> throw new IllegalStateException();
            case FunctionCall call -> {
                compileExpr(call.getFunction());
                call.getArguments().forEach(this::compileExpr);
                emit(FUNCTION_CALL, call.getArguments().size());
            }
            case VarRef varRef -> {
                VarAccess varAccess = varRef.getVarName();

                if (varAccess instanceof ArrayAccess arrayAccess) {
                    Instruction arrayVarInsn = getVarInsn(varRef.getDeclaration());
                    emit(arrayVarInsn);

                    for (Expr index : arrayAccess.getIndexes()) {
                        compileExpr(index);
                    }

                    emit(ARRAY_ACCESS);
                } else {
                    emit(getVarInsn(varRef.getDeclaration()));
                }
            }

            case StringExpr strExpr -> {
                var constantIndex = blob.getCode().constantTable().size();
                blob.getCode().constantTable().add(strExpr.getValue());

                emit(PUSH_CONSTANT, constantIndex);
            }
            case ArrayExpr arrayExpr -> {
                for (Expr element : arrayExpr.getElements()) {
                    compileExpr(element);
                }

                emit(BUILD_ARRAY, arrayExpr.getElements().size());
            }

            case BoolExpr boolExpr -> {
                var constantIndex = blob.getCode().constantTable().size();
                blob.getCode().constantTable().add(boolExpr.isValue());

                emit(PUSH_CONSTANT, constantIndex);
            }
            case NumberLit numlit -> {
                var constantNumber = blob.getCode().constantTable().size();
                blob.getCode().constantTable().add(numlit.getValue());
                emit(PUSH_CONSTANT, constantNumber);
            }
            case ComparisonExpr comparison -> {
                compileExpr(comparison.getLeft());
                for (int i = 0; i < comparison.getOperators().size(); i++) {
                    compileExpr(comparison.getRight().get(i));
                    emit(switch (comparison.getOperators().get(i)) {
                        case LESS -> LESS;
                        case LESS_EQUAL -> LESS_EQUAL;
                        case GREATER -> GREATER;
                        case GREATER_EQUAL -> GREATER_EQUAL;
                        case EQUAL_EQUAL -> EQUAL_EQUAL;
                        case NOT_EQUAL -> NOT_EQUAL;
                        default -> throw new IllegalArgumentException();
                    });
                }
            }


            case LogicalExpr logical -> {
                System.out.println("Operator:" + logical.getOperators());
                compileExpr(logical.getLeft());
                var operator = logical.getOperators().get(0);
                var skip = emit(operator == Expr.Operation.AND ? JUMP_FALSE : JUMP_TRUE, Integer.MAX_VALUE);
                emit(POP);
                for (Expr right : logical.getRight()) {
                    compileExpr(right);
                }
                backPatch(skip);
            }

            case IncrementExpr increment -> {
                Instruction variableInsn = getVarInsn(increment.getVariable().getDeclaration());

                emit(variableInsn);

                var oneIndex = blob.getCode().constantTable().size();
                blob.getCode().constantTable().add(1.0);
                emit(PUSH_CONSTANT, oneIndex);

                emit(increment.isIncrement() ? ADD : SUBTRACT);

                switch (variableInsn.getOpcode()) {
                    case GET_GLOBAL -> emit(SET_GLOBAL, variableInsn.getArg1());
                    case GET_LOCAL -> emit(SET_LOCAL, variableInsn.getArg1());
                    default ->
                            throw new IllegalArgumentException("Unsupported variable scope for increment expression.");
                }
            }


            case Expr binaryExpr -> {
                /* Must not be a subclass.  */
                assert binaryExpr.getClass() == Expr.class;
                compileExpr(binaryExpr.getLhs());
                compileExpr(binaryExpr.getRhs());
                emit(switch (binaryExpr.getOperation()) {
                    case ADD -> ADD;
                    case DIV -> DIVIDE;
                    case MUL -> MULTIPLY;
                    case SUB -> SUBTRACT;
                    case POW -> RAISE;
                    default -> throw new IllegalArgumentException();
                });
            }
        }
    }
}
