package org.example.snackScript.ast;


import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Getter
@Setter
public class Assign extends Statement{
    private  VarAccess name;
    private  List<Expr> indices;
    private  Expr value;
    private Declaration declaration;

    public Assign(Location location, VarAccess name, Expr value) {
        super(location);
        this.name = name;
        this.value = value;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.node("Assign", () -> {
            name.prettyPrint(pp);
            pp.node("value", () -> value.prettyPrint(pp));
        });
    }

}
