package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper=true)
public class BoolExpr extends Expr {
    private boolean value;

    public BoolExpr(Location location, boolean value) {
        super(location);
        this.value = value;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.node("boolean", () -> pp.terminal(String.valueOf(value)));
    }
}
