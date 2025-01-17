package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class LogicalExpr extends Expr {
    private final Expr left;
    private final List<Operation> operators;
    private final List<Expr> right;

    public LogicalExpr(Location location, Expr left, List<Operation> operators, List<Expr> right) {
        super(location);
        this.left = left;
        this.operators = operators;
        this.right = right;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.node("LogicalExpr", () -> {
            pp.node("left", () -> left.prettyPrint(pp));
            pp.node("operators", () -> operators.forEach(op -> pp.terminal(op.label)));
            pp.node("right", () -> right.forEach(expr -> expr.prettyPrint(pp)));
        });
    }
}
