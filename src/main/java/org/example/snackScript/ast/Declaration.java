package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/** A variable declaration.  */
@Getter
@Setter
@EqualsAndHashCode(callSuper=true)
public class Declaration extends Statement {
    private VarAccess name;
    private Type declaredType;
    private Expr value;
    private Type type;

    public Declaration(Location location, VarAccess name, Type declaredType){
        super(location);
        this.name = name;
        this.declaredType = declaredType;
    }

    public Declaration(Location location, VarAccess name, Type declaredType, Expr value){
        super(location);
        this.name = name;
        this.declaredType = declaredType;
        this.value = value;
    }

    public Declaration(Location location, VarAccess name, Expr value){
        super(location);
        this.name = name;
        this.value = value;
    }

    public Declaration(Location location, VarAccess name){
        super(location);
        this.name = name;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
	pp.node("declaration of %s".formatted(name),
		() -> {
            if (value != null) {
                value.prettyPrint(pp);
            }
		});
    }

    @Override
    public String toString() {
        return "Declaration{" +
                "name=" + name +
                ", declaredType=" + declaredType +
                ", value=" + value +
                ", type=" + type +
                '}';
    }
}
