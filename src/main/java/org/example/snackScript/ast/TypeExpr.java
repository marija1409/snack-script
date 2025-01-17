package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class TypeExpr extends Tree {
    public enum TypeKind {
        NUM,    // 'num'
        BOOL,   // 'bool'
        STRING, // 'line'
        ARRAY   // 'bunch<type>'
    }

    private TypeKind typeKind;
    private TypeExpr elementType;


    public TypeExpr(Location location, TypeKind typeKind) {
        super(location);
        this.typeKind = typeKind;
        this.elementType = null;
    }


    public TypeExpr(Location location, TypeExpr elementType) {
        super(location);
        this.typeKind = TypeKind.ARRAY;
        this.elementType = elementType;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
        pp.node("type", () -> {
            if (typeKind == TypeKind.ARRAY) {
                pp.terminal("bunch<");
                if (elementType != null) {
                    elementType.prettyPrint(pp);
                }
                pp.terminal(">");
            } else {
                pp.terminal(typeKind.name().toLowerCase());
            }
        });
    }

    @Override
    public String toString() {
        if (typeKind == TypeKind.ARRAY) {
            return "bunch<" + (elementType != null ? elementType.toString() : "") + ">";
        }
        return typeKind.name().toLowerCase();
    }
}
