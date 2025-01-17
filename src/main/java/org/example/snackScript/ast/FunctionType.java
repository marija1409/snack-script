package org.example.snackScript.ast;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

public class FunctionType implements Type{
    private Type returnType;
    private List<Type> parameterTypes;

    public FunctionType(Type returnType, List<Type> parameterTypes) {
        this.returnType = returnType;
        this.parameterTypes = parameterTypes;
    }

    @Override
    public String typeName() {
        String args = parameterTypes.stream()
                .map(Type::typeName)
                .reduce((a,b) -> a + "," + b)
                .orElse("");

        //vracamo (tipovi parametara) -> returnType
        return "(" + args + ")" + returnType.typeName();
    }
}
