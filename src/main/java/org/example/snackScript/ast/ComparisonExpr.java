package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ComparisonExpr extends Expr {
    private final Expr left;
    private final List<Expr.Operation> operators;
    private final List<Expr> right;

    // Updated constructor to handle a list of operators and right expressions
    public ComparisonExpr(Location location, Expr left, List<Expr.Operation> operators, List<Expr> right) {
        super(location);
        this.left = left;
        this.operators = operators;
        this.right = right;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.node("ComparisonExpr", () -> {
            pp.node("left", () -> left.prettyPrint(pp));  // Pretty print the left operand
            pp.node("operators", () -> {
                // Pretty print each operator
                for (Expr.Operation op : operators) {
                    pp.terminal(op.name());  // Print operator name
                }
            });
            pp.node("right", () -> {
                // Pretty print each right-hand operand
                for (Expr r : right) {
                    r.prettyPrint(pp);
                }
            });
        });
    }

}
