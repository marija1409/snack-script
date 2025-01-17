package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class VarAccess {
    private String varName;

    public VarAccess(String varName) {
        this.varName = varName;
    }

    @Override
    public String toString() {
        return varName;
    }

    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.terminal( varName);
    }


}
