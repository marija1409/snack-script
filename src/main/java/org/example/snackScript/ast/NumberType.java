package org.example.snackScript.ast;

public class NumberType implements Type {
    @Override
    public String typeName() {
        return "Number";
    }

    @Override
    public String toString() {
        return typeName();
    }
}
