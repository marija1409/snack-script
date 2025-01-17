package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.example.snackScript.vm.Blob;
import org.example.snackScript.vm.Instruction;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode
public class Block extends Statement {

    private List<Statement> body;

    public Block(Location location, List<Statement> body) {
        super(location);
        this.body = body;
    }



    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.node("Block", () -> {
            for (Statement statement : body) {
                statement.prettyPrint(pp);
            }
        });
    }
}
