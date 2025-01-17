package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper=true)
public class ArrayExpr extends Expr {
    private List<Expr> elements;

    public ArrayExpr(Location location, List<Expr> elements) {
	super(location);
	this.elements = elements;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
	pp.node("array", () -> elements.forEach(x -> x.prettyPrint(pp)));
    }
}
