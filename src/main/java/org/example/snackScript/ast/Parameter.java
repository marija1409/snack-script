package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper=true)

public class Parameter extends Statement {
    private String name;

    public Parameter(Location location, String name) {
        super(location);
        this.name = name;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.terminal(name);
    }
}
