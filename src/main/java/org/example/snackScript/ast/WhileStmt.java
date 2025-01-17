package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class WhileStmt extends Statement {
    private final List<Expr> conditions; // List of conditions
    private final Block body;

    public WhileStmt(Location location, List<Expr> conditions, Block body) {
        super(location);
        this.conditions = conditions;
        this.body = body;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.node("while", () -> {
            for (Expr condition : conditions) {
                condition.prettyPrint(pp);
            }
            body.prettyPrint(pp);
        });
    }
}
