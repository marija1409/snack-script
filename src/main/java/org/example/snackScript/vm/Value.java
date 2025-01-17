package org.example.snackScript.vm;

import java.io.PrintStream;
import java.util.List;

public sealed interface Value {
    void print(PrintStream out);

    record Number(double number) implements Value {
        @Override
        public void print(PrintStream out) {
            out.print(number);
        }
    }

    record Vector(List<Value> elements) implements Value {
        @Override
        public void print(PrintStream out) {
            out.print('[');
            var first = true;
            for (var e : elements) {
                if (!first) out.print(", ");
                first = false;
                e.print(out);
            }
            out.print(']');
        }
    }

    record StringValue(String value) implements Value {
        @Override
        public void print(PrintStream out) {
            out.print('"' + value + '"');
        }
    }

    record BooleanValue(boolean value) implements Value {
        @Override
        public void print(PrintStream out) {
            out.print(value);
        }
    }

    record Array(List<Value> elements) implements Value {
        @Override
        public void print(PrintStream out) {
            out.print("[");
            var first = true;
            for (var e : elements) {
                if (!first) out.print(", ");
                first = false;
                e.print(out);
            }
            out.print("]");
        }
    }

    /** This language supports function nesting.  As a result of the laziness
     of the author, however, these values are all immutable.  */
    public record Closure(Blob code,  Value[] upvalues,  int localCount) implements Value
    {
        @Override
        public void print(PrintStream out) {
            out.printf("<function %s>", System.identityHashCode(code));
        }
    }
}
