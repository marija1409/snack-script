package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class IncrementExpr extends Expr {
    private final VarRef variable;
    private final boolean isIncrement;

    public IncrementExpr(Location location, VarRef variable, boolean isIncrement) {
        super(location);
        this.variable = variable;
        this.isIncrement = isIncrement;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        // Print the node with either "++" or "--"
        pp.node(isIncrement ? "Increment" : "Decrement", () -> {
            variable.prettyPrint(pp);
        });
    }

    @Override
    public String toString() {
        return "IncrementExpr{" +
                "variable=" + variable +
                ", isIncrement=" + isIncrement +
                '}';
    }
}
