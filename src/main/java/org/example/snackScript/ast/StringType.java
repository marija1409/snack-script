package org.example.snackScript.ast;

public class StringType implements Type{
    @Override
    public String typeName() {
        return "String";
    }

    @Override
    public String toString() {
        return typeName();
    }
}
