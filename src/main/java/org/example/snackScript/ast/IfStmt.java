package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class IfStmt extends Statement {
    private final List<Expr> conditions; // List of conditions
    private final Block ifBody;
    private final Block elseBody;

    public IfStmt(Location location, List<Expr> conditions, Block ifBody, Block elseBody) {
        super(location);
        this.conditions = conditions;
        this.ifBody = ifBody;
        this.elseBody = elseBody;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.node("if", () -> {
            for (Expr condition : conditions) {
                condition.prettyPrint(pp);
            }
            ifBody.prettyPrint(pp);
            if (elseBody != null) {
                elseBody.prettyPrint(pp);
            }
        });
    }
}
