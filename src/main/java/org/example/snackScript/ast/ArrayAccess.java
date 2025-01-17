package org.example.snackScript.ast;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Getter
@Setter
@EqualsAndHashCode
public class ArrayAccess extends VarAccess{
    private final List<Expr> indexes;


    public ArrayAccess(String varName, List<Expr> indexes) {
        super(varName);
        this.indexes = indexes;
    }
}
