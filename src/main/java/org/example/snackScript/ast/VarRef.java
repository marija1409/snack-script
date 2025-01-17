package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper=true)
public class VarRef extends Expr {
    private VarAccess varName;
    private Declaration declaration;

    protected VarRef(Location location, VarAccess varName) {
        super(location);
        this.varName = varName;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
	pp.node("var", () -> pp.terminal(String.valueOf(varName)));
    }

    @Override
    public String toString() {
        return varName.toString();
    }
}
