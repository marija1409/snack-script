package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class InputStmt extends Statement {
    private final String prompt;

    public InputStmt(Location location, String prompt) {
        super(location);
        this.prompt = prompt;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.node("input", () -> pp.keyValue("prompt", prompt));
    }
}