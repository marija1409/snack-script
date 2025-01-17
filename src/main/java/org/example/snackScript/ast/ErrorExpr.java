package org.example.snackScript.ast;

public final class ErrorExpr extends Expr {
    protected ErrorExpr(Location location) {
        super(location);
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.node("error", () -> {});
    }
}

