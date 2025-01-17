package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class FunctionStmt extends Declaration{
    private final VarAccess name;
    private final Type type;
    private final List<Declaration> parameters;
    private final Block body;
    private Type expectedType;

    public FunctionStmt(Location location, VarAccess name, Type type, List<Declaration> parameters, Block body, Type expectedType) {
        super(location, name, type);

        this.name = name;
        this.type = type;
        this.parameters = parameters;
        this.body = body;
        this.expectedType = expectedType;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.node("FunctionDeclaration", () -> {
            pp.node( "name:" + name + ", type:" + type, () -> {
                pp.node("parameters", () -> {
                    for (Declaration parameter : parameters) {
                        parameter.prettyPrint(pp);
                    }
                });
                body.prettyPrint(pp);
            });
        });


    }
}