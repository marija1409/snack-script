package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ForStmt extends Statement {
    private  Declaration initializer;
    private  Expr condition;
    private  Expr updater;
    private  Block body;

    public ForStmt(Location location, Declaration initializer, Expr condition, Expr updater, Block body) {
        super(location);
        this.initializer = initializer;
        this.condition = condition;
        this.updater = updater;
        this.body = body;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.node("for", () -> {
            if (initializer != null) initializer.prettyPrint(pp);
            if (condition != null) condition.prettyPrint(pp);
            if (updater != null) updater.prettyPrint(pp);
            body.prettyPrint(pp);
        });
    }


}