package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ReturnStmt extends Statement {
    private  Expr value;

    public ReturnStmt(Location location, Expr value) {
        super(location);
        this.value = value;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.node("return", () -> {
            if (value != null) value.prettyPrint(pp);
        });
    }
}