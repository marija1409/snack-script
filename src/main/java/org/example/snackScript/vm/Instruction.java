package org.example.snackScript.vm;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public final class Instruction {

    public enum Code {
        // Arithmetic Operations
        ADD,       // PLUS
        SUBTRACT,  // MINUS
        MULTIPLY,  // STAR
        DIVIDE,    // SLASH
        RAISE,     // Raise (to a power).

        LESS,           // <
        LESS_EQUAL,     //<=
        GREATER,        //>
        GREATER_EQUAL,  //>=
        EQUAL_EQUAL,          //==
        NOT_EQUAL,      //!=

        ARRAY_ACCESS,       // Access an element in an array
        ARRAY_ASSIGN,       // Assign a value to an array element
        ARRAY_CONSTRUCT(1), // Construct an array with elements

        // Increment/Decrement
        INCREMENT,          // Increment a variable
        DECREMENT,          // Decrement a variable

        // Logical Operations
        AND,                // Logical AND
        OR,                 // Logical OR


        // Function and Return
        FUNCTION_CALL(1),  // Calling a function
        RETURN,            // Returning from a function
        RETURN_VOID,       // Returning from a function
        BUILD_CLOSURE(1),  // Generate a closure for a function

        // Stack Operations
        PUSH_CONSTANT(1),  // Push a constant from the constant tableo
        POP,               // Pop an element from the stack


        // Local variable handling.
        SET_LOCAL(1),
        GET_LOCAL(1),

        // Global variable handling.
        SET_GLOBAL(1),
        GET_GLOBAL(1),

        // Upvalue handling.
        GET_UPVALUE(1),

        // Others
        PRINT,             // Print statement
        FINISH_OUTER,      // Terminate a topmost blob
        BUILD_ARRAY,
        SET_UPVALUE,

        JUMP_TRUE(1),
        JUMP_FALSE(1),
        JUMP(1),

        ;

        public final int argCount;

        Code() {
            this(0);
        }

        Code(int argCount) {
            this.argCount = argCount;
        }
    }

    private final Code opcode;
    private int arg1 = -1;

    public Instruction(Code opcode) {
        assert opcode.argCount == 0;
        this.opcode = opcode;
    }

    public Instruction(Code opcode, int arg1) {
        assert opcode.argCount == 1;
        this.opcode = opcode;
        this.arg1 = arg1;
    }

    public Code opcode() {
        return opcode;
    }

    public void setArg1(int arg1) {
        assert opcode.argCount >= 1;
        this.arg1 = arg1;
    }

    @Override
    public String toString() {
        var s = new StringBuilder();
        s.append(opcode);
        if (opcode.argCount >= 1) s.append(" ").append(arg1);
        return s.toString();
    }
}
