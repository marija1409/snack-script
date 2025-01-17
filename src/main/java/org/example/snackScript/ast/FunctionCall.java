package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper=true)
public final class FunctionCall extends Expr {

    private String functionName;
    private List<Expr> arguments;
    private VarRef function;

    public FunctionCall(Location location, String functionName, List<Expr> arguments) {
        super(location);
        this.functionName = functionName;
        this.arguments = arguments;
        this.function = new VarRef(location, new VarAccess(functionName));
    }

    private Type resultType;

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.node(
                "FunctionCall",
                () -> {
                    pp.node("functionName", () -> pp.terminal(functionName.toString()));

                    pp.node(
                            "arguments",
                            () -> arguments.forEach(arg -> arg.prettyPrint(pp))
                    );

                    if (getResultType() != null) {
                        pp.node(
                                "type",
                                () -> pp.terminal(getResultType().typeName())
                        );
                    }
                }
        );
    }
}
