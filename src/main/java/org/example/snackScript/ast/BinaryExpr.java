package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class BinaryExpr extends Expr {
    private final Expr left;
    private final String operator;
    private final Expr right;

    public BinaryExpr(Location location, Expr left, String operator, Expr right) {
        super(location);
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.node("BinaryExpr (" + operator + ")", () -> {
            left.prettyPrint(pp);
            right.prettyPrint(pp);
        });
    }
}
