package org.example.snackScript;

import org.example.snackScript.ast.*;

import java.util.*;


public class Typecheck {
    private SnackScript snackScript;
    private FunctionStmt currentFunction;
    private List<FunctionStmt> functions = new ArrayList<>();
    private Declaration currentForInitializer;


    private List<Map<String, Declaration>> environments = new ArrayList<>();

    public void openBlock() {
        environments.add(new HashMap<>());
    }

    public void closeBlock() {
        environments.removeLast();
    }

    private void pushDecl(String name, Declaration declaration) {
        var exists = environments.getLast().put(name, declaration);

        if (exists != null) {
            snackScript.error(declaration.getLocation(), "Cannot change declaration!");
        }
    }

    public Optional<Declaration> search(Location location, String name) {
        for (var range : environments.reversed()) {
            if (range.get(name) != null) {
                return Optional.of(range.get(name));
            }
        }
        snackScript.error(location, "Cannot find variable " + name + " in current scope!");
        return Optional.empty();
    }

    public Typecheck(SnackScript snackScript) {
        this.snackScript = snackScript;
    }

    //ovo otvaramo iz main-a kada pokrenemo novi typecheck
    public void typecheck(StatementList block) {
        openBlock();
        /* Typecheck all statements.  */
        block.getStmts().forEach(this::typecheck);
        closeBlock();
    }

    public void typecheck(Block block) {
        block.getBody().forEach(this::typecheck);
    }

    private boolean isCompatibleType(Type declaredType, Type valueType) {
        //System.out.println("Checking compatibility: " + declaredType + " with " + valueType);

        if (declaredType.equals(valueType)) {
            return true;
        }

        if (declaredType instanceof ArrayType declaredArrayType && valueType instanceof ArrayType valueArrayType) {
            return isCompatibleType(declaredArrayType.getElementType(), valueArrayType.getElementType());
        }

        return false;
    }

    public FunctionStmt getFunction(String name, List<Type> argumentTypes) {

        for (FunctionStmt func : functions) {
            if (func.getName().toString().equals(name)) {
                List<Type> funcArgumentTypes = new ArrayList<>();
                for (Declaration arg : func.getParameters()) {
                    funcArgumentTypes.add(arg.getType());
                }

                if (funcArgumentTypes.equals(argumentTypes)) {
                    return func;
                }
            }
        }
        return null;
    }

    public FunctionType getFunctionType(String name, List<Type> argumentTypes) {
        //System.out.println("Searching for function: " + name + " with arguments: " + argumentTypes);


        for (FunctionStmt func : functions) {
            //System.out.printf("Function: %s, Args: %s%n", func.getName(), func.getParameters());
            if (func.getName().toString().equals(name)) {
                //System.out.println("Function name: " + func.getName() + " Given name: " + name);
                List<Type> funcArgumentTypes = new ArrayList<>();
                for (Declaration arg : func.getParameters()) {
                    funcArgumentTypes.add(arg.getType());
                }
                //System.out.println("Function argument types: " + funcArgumentTypes + "Checking arguemnt type: " + argumentTypes ) ;
                if (funcArgumentTypes.equals(argumentTypes)) {
                    return new FunctionType(func.getExpectedType(), funcArgumentTypes);
                }
            }
        }
        return null;
    }


    public void typecheck(Statement statement) {
        //razliciti tipovi statmenta...
        //Block, Declaration,Assign, ExprStmt, ForStmt, FunctionStmt, IfStmt, InputStmt
        //PrintStmt, ReturnStmt, WhileStmt

        switch (statement) {
            case Block block -> {
                openBlock();
                block.getBody().forEach(this::typecheck);
                closeBlock();
            }
            case FunctionStmt funcStmt -> {
                FunctionStmt oldFunc = currentFunction;
                functions.add(funcStmt);

                try {
                    currentFunction = funcStmt;

                    funcStmt.setDeclaredType(funcStmt.getType());
                    funcStmt.setType(funcStmt.getType());

                    openBlock();
                    for (Declaration declaration : funcStmt.getParameters()) {
                        typecheck(declaration);
                    }
                    if (funcStmt.getBody() != null) {
                        typecheck(funcStmt.getBody());
                    }
                    closeBlock();
                } finally {
                    currentFunction = oldFunc;
                }
            }

            case Declaration declaration -> {
                if (declaration.getValue() != null) {
                    var newVal = typecheck(declaration.getValue());
                    declaration.setValue(newVal);

                    if (!isCompatibleType(declaration.getDeclaredType(), newVal.getReturnType())) {
                        snackScript.error(declaration.getLocation(),
                                "Type mismatch: cannot declare %s with a value of type %s."
                                        .formatted(declaration.getDeclaredType().typeName(), newVal.getReturnType().typeName()));
                        return;
                    }
                    declaration.setType(declaration.getDeclaredType());
                } else {
                    declaration.setType(declaration.getDeclaredType());
                }

                pushDecl(declaration.getName().getVarName(), declaration);
            }


            case Assign assign -> {
                var newVal = typecheck(assign.getValue());
                assign.setValue(newVal);
                String name = assign.getName().getVarName();

                if (assign.getName() instanceof ArrayAccess) {
                    //System.out.println("Here we are" + assign.getName());
                    for (int i = 0; i < (((ArrayAccess) assign.getName()).getIndexes().size()); i++) {
                        ((ArrayAccess) assign.getName()).getIndexes().set(i, typecheck(((ArrayAccess) assign.getName()).getIndexes().get(i)));
                    }
                }

                Optional<Declaration> check = search(assign.getLocation(), name);


                if (check.isPresent()) {
                    Type assignType = check.get().getType();
                    if (assignType instanceof ArrayType) {
                        while (assignType instanceof ArrayType) {
                            assignType = ((ArrayType) assignType).getElementType();
                        }
                    }
                    if (assignType != assign.getValue().getReturnType()) {
                        snackScript.error(assign.getLocation(), "Type Mismatch on Assign Value: " + name);
                    }
                }
                //setujemo deklaraciju
                check.ifPresent(assign::setDeclaration);
            }

            case ExprStmt exprStmt -> {
                exprStmt.setExpr(typecheck(exprStmt.getExpr()));
            }
            case ForStmt forStmt -> {
                openBlock();

                if (forStmt.getInitializer() != null) {
                    currentForInitializer = forStmt.getInitializer();
                    typecheck(currentForInitializer);
                    if (currentForInitializer.getDeclaredType() != snackScript.getNumberType()) {
                        snackScript.error(currentForInitializer.getLocation(),
                                "For loop initializer must be of type 'Number'.");
                    }
                    if (currentForInitializer.getValue() != null) {
                        Expr newVal = typecheck(currentForInitializer.getValue());
                        currentForInitializer.setValue(newVal);
                    }
                }

                if (forStmt.getCondition() != null) {
                    Expr condition = typecheck(forStmt.getCondition());
                    if (!condition.getReturnType().equals(snackScript.getBooleanType())) {
                        snackScript.error(forStmt.getCondition().getLocation(), "For loop condition must evaluate to a boolean.");
                    }
                    forStmt.setCondition(condition);
                }

                if (forStmt.getUpdater() != null) {
                    Expr updater = typecheck(forStmt.getUpdater());
                    if (!(updater instanceof IncrementExpr)) {
                        snackScript.error(forStmt.getUpdater().getLocation(), "For loop updater must modify a variable (e.g., increment or assignment).");
                    }
                    if (updater instanceof IncrementExpr incrementExpr) {
                        VarRef variable = incrementExpr.getVariable();
                        Optional<Declaration> declOpt = search(variable.getLocation(), variable.getVarName().getVarName());
                        if (declOpt.isEmpty() || !declOpt.get().equals(currentForInitializer)) {
                            snackScript.error(variable.getLocation(), "The variable being incremented is not the declared initializer of the for loop.");
                        } else {
                            variable.setDeclaration(declOpt.get());
                        }
                    }
                    forStmt.setUpdater(updater);
                }

                if (forStmt.getBody() != null) {
                    typecheck(forStmt.getBody());
                }

                currentForInitializer = null;

                closeBlock();
            }


            case IfStmt ifStmt -> {
                for (Expr condition : ifStmt.getConditions()) {
                    Expr checkedCondition = typecheck(condition);
                    if (!checkedCondition.getReturnType().equals(snackScript.getBooleanType())) {
                        snackScript.error(condition.getLocation(), "If condition must evaluate to a boolean.");
                    }
                }
                openBlock();
                typecheck(ifStmt.getIfBody());
                closeBlock();
                if (ifStmt.getElseBody() != null) {
                    openBlock();
                    typecheck(ifStmt.getElseBody());
                    closeBlock();
                }
            }

            case WhileStmt whileStmt -> {
                for (int i = 0; i < whileStmt.getConditions().size(); i++) {
                    whileStmt.getConditions().set(i, typecheck(whileStmt.getConditions().get(i)));
                    if (whileStmt.getConditions().get(i).getReturnType() != snackScript.getBooleanType()) {
                        snackScript.error(whileStmt.getLocation(), "Condition must be of type 'bool'.");
                    }
                }
                if (whileStmt.getBody() != null) {
                    openBlock();
                    typecheck(whileStmt.getBody());
                    closeBlock();
                }

            }
            case InputStmt inputStmt -> {
                snackScript.error(inputStmt.getLocation(), "This should not exist!");
            }
            case PrintStmt printStmt -> {
                printStmt.getArgs().forEach(this::typecheck);
            }
            case ReturnStmt returnStmt -> {
                if (currentFunction == null) {
                    snackScript.error(returnStmt.getLocation(),
                            "Return statement must be inside a function.");
                    return;
                }

                var curr = currentFunction.getName();
                var returnFunc = currentFunction.getExpectedType();


                if (returnStmt.getValue() != null) {
                    Expr returnExpr = typecheck(returnStmt.getValue());
                    if (!returnExpr.getReturnType().equals(currentFunction.getExpectedType())) {
                        snackScript.error(returnStmt.getLocation(),
                                "Return type mismatch: expected '%s' but got '%s'.",
                                currentFunction.getExpectedType().typeName(), returnExpr.getReturnType().typeName());
                        return;
                    }
                } else {
                    snackScript.error(returnStmt.getLocation(), "Missing return statement.");
                }
            }
            default -> throw new IllegalStateException("Unexpected statment: " + statement);
        }
    }

    private Expr tryAndConvert(Type expectedType, Expr expr) {
        if (expr.getReturnType().equals(expectedType)) {
            return expr;
        } else {
            snackScript.error(expr.getLocation(),
                    "Cannot convert expression of type '%s' to expected type '%s'.",
                    expr.getReturnType().typeName(), expectedType.typeName());
            return expr;
        }
    }


    private Expr typecheck(Expr expr) {
        //System.out.println("Processing expression of type: " + expr.getClass().getSimpleName());
        /* A few expressions are subclasses.  Check those separately.  */
        switch (expr) {
            case ErrorExpr errorExpr -> {
                errorExpr.setReturnType(snackScript.getStringType());
                return errorExpr;
            }
            case NumberLit numberLit -> {
                numberLit.setReturnType(snackScript.getNumberType());
                return numberLit;
            }
            case StringExpr stringExpr -> {
                stringExpr.setReturnType(snackScript.getStringType());
                return stringExpr;
            }
            case BoolExpr boolExpr -> {
                boolExpr.setReturnType(snackScript.getBooleanType());
                return boolExpr;
            }

            case VarRef varRef -> {
                if (varRef.getVarName() instanceof ArrayAccess arrayAccess) {
                    Optional<Declaration> arrayDeclOpt = search(varRef.getLocation(), arrayAccess.getVarName());
                    if (arrayDeclOpt.isEmpty()) {
                        snackScript.error(varRef.getLocation(), "Array variable '%s' not declared.".formatted(arrayAccess.getVarName()));
                        return varRef;
                    }
                    Declaration arrayDecl = arrayDeclOpt.get();

                    if (!(arrayDecl.getType() instanceof ArrayType arrayType)) {
                        snackScript.error(varRef.getLocation(), "Variable '%s' is not an array.".formatted(arrayAccess.getVarName()));
                        return varRef;
                    }

                    for (int i = 0; i < arrayAccess.getIndexes().size(); i++) {
                        Expr indexExpr = typecheck(arrayAccess.getIndexes().get(i));

                        if (!indexExpr.getReturnType().equals(snackScript.getNumberType())) {
                            snackScript.error(arrayAccess.getIndexes().get(i).getLocation(),
                                    "Array index must be of type 'Number', but found '%s'.".formatted(indexExpr.getReturnType().typeName()));
                        }

                        arrayAccess.getIndexes().set(i, indexExpr);
                    }

                    varRef.setReturnType(arrayType.getElementType());
                    varRef.setDeclaration(arrayDecl);
                    return varRef;
                }

                Optional<Declaration> check = search(varRef.getLocation(), varRef.getVarName().getVarName());
                if (check.isPresent()) {
                    Declaration decl = check.get();
                    varRef.setReturnType(decl.getType());
                    varRef.setDeclaration(decl);
                    return varRef;
                } else {
                    snackScript.error(varRef.getLocation(), "Variable '%s' not declared.".formatted(varRef.getVarName().getVarName()));
                    return varRef;
                }
            }


            case ArrayExpr arrayExpr -> {
                if (arrayExpr.getElements().isEmpty()) {
                    arrayExpr.setReturnType(snackScript.listOfType(null));
                    return arrayExpr;
                }

                Type expectedElementType = null;

                for (int i = 0; i < arrayExpr.getElements().size(); i++) {
                    Expr element = typecheck(arrayExpr.getElements().get(i));

                    if (i == 0) {
                        expectedElementType = element.getReturnType();
                    } else {
                        if (!isCompatibleType(expectedElementType, element.getReturnType())) {
                            snackScript.error(element.getLocation(),
                                    "All elements in the array must have the same type. Found: %s and %s."
                                            .formatted(expectedElementType.typeName(), element.getReturnType().typeName()));
                        }
                    }
                }

                arrayExpr.setReturnType(snackScript.listOfType(expectedElementType));
                return arrayExpr;
            }


            case FunctionCall functionCall -> {
                List<Type> argumentTypes = new ArrayList<>();
                for (Expr arg : functionCall.getArguments()) {
                    Expr checkedArg = typecheck(arg);
                    argumentTypes.add(checkedArg.getReturnType());
                }


                FunctionType functionType = getFunctionType(functionCall.getFunctionName(), argumentTypes);

                if (functionType == null) {
                    snackScript.error(functionCall.getLocation(),
                            "Cannot find function '%s' with matching argument types: %s.",
                            functionCall.getFunctionName(), argumentTypes);
                    return functionCall;
                }

                for (int i = 0; i < functionCall.getArguments().size(); i++) {
                    Expr argument = functionCall.getArguments().get(i);
                    Type expectedType = functionType.getParameterTypes().get(i);
                    Type actualType = argument.getReturnType();

                    if (!actualType.equals(expectedType)) {
                        snackScript.error(argument.getLocation(),
                                "Argument type mismatch at index %d: expected '%s' but got '%s'.",
                                i, expectedType.typeName(), actualType.typeName());
                    }
                }

                functionCall.getFunction().setDeclaration(getFunction(functionCall.getFunctionName(), argumentTypes));
                functionCall.setReturnType(functionType.getReturnType());
                return functionCall;
            }

            case ComparisonExpr comparisonExpr -> {
                Expr left = typecheck(comparisonExpr.getLeft());

                for (int i = 0; i < comparisonExpr.getOperators().size(); i++) {
                    Expr right = typecheck(comparisonExpr.getRight().get(i));

                    if (!left.getReturnType().equals(right.getReturnType())) {
                        snackScript.error(comparisonExpr.getLocation(),
                                "Type mismatch in comparison: left is '%s', right is '%s'.",
                                left.getReturnType().typeName(), right.getReturnType().typeName());
                    }

                    left = right;
                }

                comparisonExpr.setReturnType(snackScript.getBooleanType());
                return comparisonExpr;
            }

            case LogicalExpr logicalExpr -> {
                System.out.println("In logical expression");
                Expr left = typecheck(logicalExpr.getLeft());
                if (!left.getReturnType().equals(snackScript.getBooleanType())) {
                    snackScript.error(logicalExpr.getLocation(), "Logical expressions must return a boolean value on the left side.");
                }

                for (Expr rightExpr : logicalExpr.getRight()) {
                    Expr checkedRight = typecheck(rightExpr);
                    if (!checkedRight.getReturnType().equals(snackScript.getBooleanType())) {
                        snackScript.error(rightExpr.getLocation(), "Logical expressions must return boolean values.");
                    }
                }

                logicalExpr.setReturnType(snackScript.getBooleanType());
                return logicalExpr;
            }
            case IncrementExpr incrementExpr -> {
                VarRef variable = incrementExpr.getVariable();
                Optional<Declaration> declOpt = search(variable.getLocation(), variable.getVarName().getVarName());

                if (declOpt.isEmpty()) {
                    snackScript.error(variable.getLocation(), "Variable '%s' not declared.".formatted(variable.getVarName().getVarName()));
                    return incrementExpr;
                }

                Declaration declaration = declOpt.get();

                if (!declaration.equals(currentForInitializer)) {
                    snackScript.error(variable.getLocation(), "The variable being incremented is not the declared initializer of the for loop.");
                }

                incrementExpr.setReturnType(declaration.getType());
                return incrementExpr;
            }


            default -> {
                // Handle other expressions that aren't explicitly handled
            }
        }
        /* We have a regular expression here.  */
        switch (expr.getOperation()) {
            case ADD, DIV, MUL, POW, SUB -> {
                /* Binary number expressions.  */
                expr.setLhs(typecheck(expr.getLhs()));
                expr.setRhs(typecheck(expr.getRhs()));

                /* They both must be numbers.  */
                expr.setLhs(tryAndConvert(snackScript.getNumberType(), expr.getLhs()));
                expr.setRhs(tryAndConvert(snackScript.getNumberType(), expr.getRhs()));

                /* The result is always a number.  */
                expr.setReturnType(snackScript.getNumberType());
                return expr;
            }
            case VALUE -> {
                /* Shouldn't be possible.  */
                throw new IllegalStateException();
            }
        }

        throw new IllegalStateException();
    }

}




