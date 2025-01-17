package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper=true)
/** A statement that evaluates an expression.  */
public class ExprStmt extends Statement {
    private Expr expr;

    public ExprStmt(Location location, Expr expr) {
        super(location);
        this.expr = expr;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
	pp.node("expr_stmt", () -> expr.prettyPrint(pp));
    }
}
