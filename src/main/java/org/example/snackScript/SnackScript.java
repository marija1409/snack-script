package org.example.snackScript;

import com.sun.jdi.BooleanType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.example.snackScript.ast.*;
import org.example.snackScript.vm.Blob;
import org.example.snackScript.vm.Function;

import java.io.PrintStream;
import java.util.*;

@Getter
@Setter

public class SnackScript {
    @Getter(AccessLevel.NONE)
    private boolean hadError = false;
    @Getter(AccessLevel.NONE)
    private boolean hadRuntimeError = false;

    public boolean hadError() {
        return hadError;
    }

    public boolean hadRuntimeError() {
        return hadRuntimeError;
    }

    public ANTLRErrorListener errorListener() {
        /* ANTLR reports many kinds of errors, but we're only interested in
           syntax errors, so lets steal those from BaseErrorListener.  */
        return new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer,
                                    Object offendingSymbol, int line,
                                    int charPositionInLine, String msg,
                                    RecognitionException e) {
                var pos = new Position(line, charPositionInLine);
                error(new Location(pos, pos), "%s", msg);
            }
        };
    }

    public void error(Location location, String message, Object... args) {
        /* Could be improved to handle end also, later.  */
        var p = location.start();
        System.err.printf ("error: %d:%d: %s\n", p.line(), p.column(),
                message.formatted(args));
        setHadError(true);
    }

    //singleton svih tipova:
    private final NumberType numberType = new NumberType();
    private final StringType stringType = new StringType();
    private final BoolType booleanType = new BoolType();
    @Getter(AccessLevel.NONE)
    private final Map<Type, ArrayType> arrayTypeMap = new HashMap<>();

    public Type listOfType(Type elementType) {
        return arrayTypeMap.computeIfAbsent(elementType, ArrayType::new);
    }

    /* Function handling.  */
    /** Function table.  Used by the VM.  */
    @Getter(AccessLevel.NONE)
    private final List<Function> functions = new ArrayList<>();

    public int addFunction(Function newFunction) {
        var itsIndex = functions.size();
        functions.add(newFunction);
        return itsIndex;
    }

    public Function getFunction(int functionId) {
        return functions.get(functionId);
    }

    /* Global variable handling.  */
    /** Assignments of global table slots to declarations.  Declaration of
     {@code d} being mapped to {@code 3} means that the global table at
     slot 3 contains the value of variable {@code d}.  */
    @Getter(AccessLevel.NONE)
    private final IdentityHashMap<Declaration, Integer> globalIndices =
            new IdentityHashMap<>();

    /** Allocate a slot in the globals table for this global variable.  */
    public int declareGlobal(Declaration newGlobal) {
        var newGlobalNumber = globalIndices.size();
        var oldIndex = globalIndices.put(newGlobal, newGlobalNumber);
        //System.out.println("new global: " + newGlobal +  " newGlobalNumber: " + newGlobalNumber);
        /* Should not have been present.  */
        assert oldIndex == null;
        return newGlobalNumber;
    }

    /** Get number of globals.  */
    public int getGlobalCount() {
        return globalIndices.size();
    }

    /** Get the slot in which {@code global} is stored in the global table.  */
    public Optional<Integer> getGlobalSlot(Declaration global) {
        var globalSlot = globalIndices.get(global);
        return Optional.ofNullable(globalSlot);
    }

    @Getter(AccessLevel.NONE)
    /** How many functions have we printed so far?  So that we can resume.  */
    private int printedFunctionCount = 0;
    @Getter(AccessLevel.NONE)
    /** How many globals have we printed so far?  So that we can resume.  */
    private int printedVariableCount = 0;

    public void dumpNewAssembly(PrintStream out, Blob bytecode) {
        if (printedVariableCount < globalIndices.size())
            out.println("New globals:");
        globalIndices
                .entrySet()
                .stream()
                .filter(e -> e.getValue() >= printedVariableCount)
                .forEach(e ->
                        out.printf("  %4x: %s\n",
                                e.getValue(), e.getKey().getName()));
        printedVariableCount = globalIndices.size();

        if (printedVariableCount < functions.size())
            out.println("New functions:");
        for (; printedFunctionCount < functions.size();
             printedFunctionCount++) {
            var fn = getFunction(printedFunctionCount);
            var fnTag = "FN%x".formatted(printedFunctionCount);
            out.printf("  %-6s: Function '%s'\n", fnTag,
                    fn.getFuncDecl().getName());
            dumpBlob(out, "  ", fn.getCode());
            out.printf("  - Upvalues:\n");
            var upvals = fn.getUpvalueMap();
            for (int u = 0; u < upvals.length; u++) {
                out.printf("    %4x: %s\n", u, upvals[u].format());
            }
        }
        out.println("Toplevel blob:");
        dumpBlob(out, "  ", bytecode);
    }

    private void dumpBlob(PrintStream out, String indent, Blob blob) {
        if (!blob.code().isEmpty())
            out.printf("%s- Code:\n", indent);
        for (int i = 0; i < blob.code().size(); i++){
            var insn = blob.code().get(i);
            out.printf("%s  %4x: %s\n", indent, i, insn);
        }
        if (!blob.constantTable().isEmpty())
            out.printf("%s- Constants:\n", indent);
        for (int i = 0; i < blob.constantTable().size(); i++){
            out.printf("%s  %4x: %s\n", indent, i, blob.constantTable().get(i));
        }
    }
}
