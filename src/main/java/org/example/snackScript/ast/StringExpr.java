package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper=true)
public class StringExpr extends Expr {
    private String value;

    public StringExpr(Location location, String value) {
        super(location);
        this.value = value;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.node("string", () -> pp.terminal("\"" + value + "\""));
    }
}
