package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode(callSuper=true)
public class Expr extends Tree {
    public enum Operation {
	ADD("+"),
	SUB("-"),

	MUL("*"),
	DIV("/"),

	POW("^"),

	AND("and"),
	OR("or"),

	LESS("<"),
	LESS_EQUAL("<="),
	GREATER(">"),
	GREATER_EQUAL(">="),
	EQUAL_EQUAL("=="),
	NOT_EQUAL("!="),

	/** A vector or a number or a variable.  */
	VALUE(null),
	;

	public final String label;

	Operation(String label) {
	    this.label = label;
	}
    }

    private Operation operation;
    private Expr lhs;
    private Expr rhs;

	private Type returnType; // gledamo koji tip podatka nasa promenljiva treba da vrati

    public Expr(Location location, Operation operation, Expr lhs, Expr rhs) {
        super(location);
	if (operation == Operation.VALUE)
	    throw new IllegalArgumentException("cannot construct a value like that");
	this.operation = operation;
	this.lhs = Objects.requireNonNull(lhs);
	this.rhs = Objects.requireNonNull(rhs);
    }

    protected Expr(Location location)
    {
	super(location);
	this.operation = Operation.VALUE;
    }

    @Override
    public void prettyPrint(ASTPrettyPrinter pp) {
	pp.node(operation.label,
		() -> {
		    lhs.prettyPrint(pp);
		    rhs.prettyPrint(pp);
		});
    }


}
