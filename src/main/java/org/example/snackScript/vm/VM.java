package org.example.snackScript.vm;

import org.example.snackScript.SnackScript;

import java.util.ArrayList;
import java.util.List;

import static org.example.snackScript.vm.Instruction.Code.*;

public class VM {
    private final SnackScript snackScript;
    private final ArrayList<Value> globals = new ArrayList<>();

    public VM(SnackScript context) {
        this.snackScript = context;
    }

    public void run(Blob blob) {
        int ip = 0;
        var callstack = new ArrayList<BlobInvocation>();

        while (globals.size() < snackScript.getGlobalCount())
            globals.add(null);

        callstack.add(new BlobInvocation(blob));

        for (; ; ) {
            var frame = callstack.getLast();
            var stack = frame.getOperandStack();
            var code = frame.getBlob().code();
            var csts = frame.getBlob().constantTable();
            var upvals = frame.getUpvalues();
            var locals = frame.getLocals();

            var insn = code.get(ip++);
            var op = insn.getOpcode();
            switch (op) {
                case ADD, DIVIDE, MULTIPLY, RAISE, SUBTRACT -> {
                    var rhs = ((Value.Number) stack.getLast()).number();
                    stack.removeLast();
                    var lhs = ((Value.Number) stack.getLast()).number();
                    stack.removeLast();
                    stack.add(new Value.Number
                            (switch (op) {
                                case ADD -> lhs + rhs;
                                case SUBTRACT -> lhs - rhs;
                                case MULTIPLY -> lhs * rhs;
                                case DIVIDE -> lhs / rhs;
                                case RAISE -> Math.pow(lhs, rhs);
                                default -> throw new IllegalArgumentException(op.name());
                            }));
                }
                case PUSH_CONSTANT -> {
                    int constantIndex = insn.getArg1();
                    var constant = csts.get(constantIndex);

                    if (constant instanceof Double) {
                        stack.add(new Value.Number((Double) constant));
                    } else if (constant instanceof String) {
                        stack.add(new Value.StringValue((String) constant));
                    } else if (constant instanceof Boolean) {
                        stack.add(new Value.BooleanValue((Boolean) constant));
                    } else if (constant instanceof Integer) {
                        stack.add(new Value.Number((Integer) constant));
                    } else {
                        throw new IllegalStateException("Unsupported constant type: " + constant.getClass());
                    }
                }

                case GET_GLOBAL -> stack.add(globals.get(insn.getArg1()));
                case GET_LOCAL -> stack.add(locals[insn.getArg1()]);
                case GET_UPVALUE -> stack.add(upvals[insn.getArg1()]);

                case SET_LOCAL -> {
                    locals[insn.getArg1()] = stack.getLast();
                    stack.removeLast();
                }
                case SET_GLOBAL -> {
                    globals.set(insn.getArg1(), stack.getLast());
                    stack.removeLast();
                }

                case LESS, LESS_EQUAL, GREATER, GREATER_EQUAL, EQUAL_EQUAL, NOT_EQUAL -> {
                    var rhs = stack.removeLast();
                    var lhs = stack.removeLast();

                    if (lhs instanceof Value.Number && rhs instanceof Value.Number) {
                        double lhsNum = ((Value.Number) lhs).number();
                        double rhsNum = ((Value.Number) rhs).number();

                        stack.add(new Value.BooleanValue(switch (op) {
                            case LESS -> lhsNum < rhsNum;
                            case LESS_EQUAL -> lhsNum <= rhsNum;
                            case GREATER -> lhsNum > rhsNum;
                            case GREATER_EQUAL -> lhsNum >= rhsNum;
                            case EQUAL_EQUAL -> lhsNum == rhsNum;
                            case NOT_EQUAL -> lhsNum != rhsNum;
                            default -> throw new IllegalArgumentException();
                        }));
                    } else if (lhs instanceof Value.StringValue && rhs instanceof Value.StringValue) {
                        var lhsString = ((Value.StringValue) lhs).value();
                        var rhsString = ((Value.StringValue) rhs).value();

                        stack.add(new Value.BooleanValue(switch (op) {
                            case EQUAL_EQUAL -> lhsString.equals(rhsString);
                            case NOT_EQUAL -> !lhsString.equals(rhsString);
                            case GREATER -> lhsString.length() > rhsString.length();
                            case LESS -> lhsString.length() < rhsString.length();
                            case GREATER_EQUAL -> lhsString.length() >= rhsString.length();
                            case LESS_EQUAL -> lhsString.length() <= rhsString.length();
                            default -> throw new IllegalArgumentException(op.name());
                        }));
                    } else {
                        throw new ClassCastException("Operands must be numbers for comparison. Left: " + lhs.getClass() + ", Right: " + rhs.getClass());
                    }
                }

                case ARRAY_ACCESS -> {
                    var indexValue = ((Value.Number) stack.removeLast()).number();

                    var arrayValue = (Value.Array) stack.removeLast();

                    if (indexValue < 0 || indexValue >= arrayValue.elements().size()) {
                        throw new IndexOutOfBoundsException("Array index out of bounds: " + indexValue);
                    }

                    stack.add(arrayValue.elements().get((int) indexValue));
                }

                case ARRAY_ASSIGN -> {
                    var newValue = stack.removeLast();

                    var indexValue = ((Value.Number) stack.removeLast()).number();

                    var arrayValue = (Value.Array) stack.removeLast();

                    if (indexValue < 0 || indexValue >= arrayValue.elements().size()) {
                        throw new IndexOutOfBoundsException("Array index out of bounds: " + indexValue);
                    }

                    arrayValue.elements().set((int) indexValue, newValue);
                }


                case BUILD_ARRAY -> {
                    int arraySize = insn.getArg1();
                    var elements = new ArrayList<Value>();

                    for (int i = 0; i < arraySize; i++) {
                        elements.add(0, stack.removeLast());
                    }
                    stack.add(new Value.Array(elements));
                }

                case PRINT -> {
                    var value = stack.removeLast();
                    value.print(System.out);
                    System.out.println();
                }
                case RETURN, RETURN_VOID -> {
                    var retValue = op == RETURN_VOID ? null : stack.removeLast();
                    ip = frame.getPrevIp();
                    callstack.removeLast();
                    if (!callstack.isEmpty()) callstack.getLast().getOperandStack().add(retValue);
                }
                case FUNCTION_CALL -> {
                    final var aty = insn.getArg1();
                    final var operands =
                            new ArrayList<>(stack.subList(stack.size() - aty - 1,
                                    stack.size()));
                    final var closure = ((Value.Closure) operands.getFirst());

                    final var newLocals = new Value[closure.localCount()];
                    for (int i = 1; i < operands.size(); i++)
                        newLocals[i - 1] = operands.get(i);

                    final var invoc =
                            new BlobInvocation(closure.code(),
                                    closure.upvalues(),
                                    newLocals,
                                    ip);
                    callstack.add(invoc);
                    ip = 0;
                    for (int i = 0; i < operands.size(); i++)
                        stack.removeLast();
                }
                case BUILD_CLOSURE -> {
                    var fn = snackScript.getFunction(insn.getArg1());
                    var um = fn.getUpvalueMap();
                    var newUpvalues = new Value[um.length];
                    for (int u = 0; u < newUpvalues.length; u++)
                        newUpvalues[u] =
                                (switch (um[u].loc()) {
                                    case UPVALUE -> upvals;
                                    case LOCAL -> locals;
                                })[um[u].slot()];
                    stack.add(new Value.Closure(fn.getCode(),
                            newUpvalues,
                            fn.getLocalCount()));
                }
                case POP -> stack.removeLast();

                case JUMP -> {
                    assert List.of(JUMP, JUMP_FALSE, JUMP_TRUE).contains(insn.getOpcode());
                    ip += Math.toIntExact(insn.getArg1());
                }
                case JUMP_FALSE -> {
                    var condition = (Value.BooleanValue) stack.getLast();
                    if (!condition.value()) {
                        ip += Math.toIntExact(insn.getArg1());
                    }
                }
                case JUMP_TRUE -> {
                    var condition = (Value.BooleanValue) stack.getLast();
                    if (condition.value()) {
                        ip += Math.toIntExact(insn.getArg1());
                    }
                }

                case FINISH_OUTER -> {
                    assert callstack.size() == 1;
                    assert ip == code.size();
                    return;
                }


                default -> throw new IllegalStateException("Unknown opcode: " + op);
            }
        }
    }

}
