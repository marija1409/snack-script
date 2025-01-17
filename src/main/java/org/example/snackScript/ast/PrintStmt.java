package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper=true)

public class PrintStmt extends Statement {
    private List<Expr> args;

    public PrintStmt(Location location, List<Expr> args) {
        super(location);
	this.args = args;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
	pp.node("print",
		() -> {
		    args.forEach(x -> x.prettyPrint(pp));
		});
    }
}
