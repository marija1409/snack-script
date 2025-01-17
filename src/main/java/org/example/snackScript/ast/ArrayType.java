package org.example.snackScript.ast;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArrayType implements Type{
    private Type elementType;

    public ArrayType(Type elementType) {
        this.elementType = elementType;
    }

    //Vracamo tip elementata koje niz sadrzi
    @Override
    public String typeName() {
        return "Array of " + elementType.typeName();
    }

    @Override
    public String toString() {
        return "type: " + typeName();
    }
}
