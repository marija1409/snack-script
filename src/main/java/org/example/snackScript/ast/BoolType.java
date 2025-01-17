package org.example.snackScript.ast;

public class BoolType implements Type{
    @Override
    public String typeName() {
        return "Boolean";
    }

    @Override
    public String toString() {
        return typeName();
    }
}
