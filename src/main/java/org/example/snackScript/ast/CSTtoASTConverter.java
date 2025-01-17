package org.example.snackScript.ast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.*;

import org.example.snackScript.SnackScript;
import snackScript.parser.SnackScriptParser;
import snackScript.parser.SnackScriptParser.*;
import snackScript.parser.SnackScriptLexer;
import snackScript.parser.SnackScriptVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;

public class CSTtoASTConverter extends AbstractParseTreeVisitor<Tree> implements SnackScriptVisitor<Tree> {

    //Added this so i can start the typecheck:
    private SnackScript snackScript;

    public CSTtoASTConverter(SnackScript snackScript) {
        this.snackScript = snackScript;
    }




    private static Location getLocation(ParserRuleContext context) {
        return getLocation(context.getStart())
                .span(getLocation(context.getStop()));
    }

    /**
     * Returns the location this terminal is in.
     */
    private static Location getLocation(TerminalNode term) {
        return getLocation(term.getSymbol());
    }

    /**
     * Returns the location this token is in.
     */
    private static Location getLocation(Token token) {
        /* The token starts at the position ANTLR provides us.  */
        var start = new Position(token.getLine(), token.getCharPositionInLine());

        /* But it does not provide a convenient way to get where it ends, so we
           have to calculate it based on length.  */
        assert !token.getText().contains("\n")
                : "CSTtoASTConverter assumes single-line tokens";
        var length = token.getText().length();
        assert length > 0;

        /* And then put it together.  */
        var end = new Position(start.line(), start.column() + length - 1);
        return new Location(start, end);
    }

    @Override
    public Tree visitStart(StartContext ctx) {
        var stmts = ctx.statement()
                /* Take all the parsed statements, ... */
                .stream()
                /* ... visit them using this visitor, ... */
                .map(this::visit)
                /* ... then cast them to statements (because 'start: statement*',
                   so they can't be anything else), ...  */
                .map(x -> (Statement) x)
                /* ... and put them into a list.  */
                .toList();
        return new StatementList(getLocation(ctx), stmts);
    }

    @Override
    public Tree visitStatement(StatementContext ctx) {
        if (ctx.getChild(0) == null) {
            System.err.println("Error: Null child in StatementContext.");
            return null; // Or handle appropriately
        }

        var substatement = visit(ctx.getChild(0));
        if (substatement instanceof Expr e) {
            /* It's an expression statement.  */
            substatement = new ExprStmt(e.getLocation(), e);
        }
        return (Statement) substatement;
    }


    @Override
    public Tree visitBlock(BlockContext ctx) {
        List<Statement> statements = ctx.statement().stream()
                .map(stmtCtx -> (Statement) visit(stmtCtx))
                .toList();
        return new Block(getLocation(ctx),statements);
    }

    @Override
    public Tree visitDeclaration(DeclarationContext ctx) {
        if (ctx.IDENTIFIER() == null) {
            System.err.println("Error: Missing identifier in declaration.");
            return null;
        }
        String identifierName = ctx.IDENTIFIER().getText();
        VarAccess varAccess = new VarAccess(identifierName);
        VarRef name = new VarRef(getLocation(ctx.IDENTIFIER()), varAccess);

        if (ctx.expr() == null) {
            Declaration d = new Declaration(getLocation(ctx), name.getVarName(), convertType(ctx.type()));
            return d;
        } else {
            Expr expr = (Expr) visit(ctx.expr());
            Declaration d = new Declaration(getLocation(ctx), name.getVarName(), convertType(ctx.type()), expr);
            return d;
        }
    }

    @Override
    public Tree visitAssign(AssignContext ctx) {
        VarRef name = (VarRef) visit(ctx.arrayAccess());
        Expr expr = (Expr) visit(ctx.expr());
        return new Assign(getLocation(ctx), name.getVarName(), expr);

    }

    @Override
    public Tree visitArrayAccess(ArrayAccessContext ctx) {
        if(ctx.name instanceof VariableReferenceContext){
            String name = ((VariableReferenceContext) ctx.name).getText();
            List<Expr> indexes = new ArrayList<>();
            VarAccess obj;
            if(!ctx.expr().isEmpty()){
                for (ExprContext index : ctx.expr()) {
                    indexes.add((Expr) visit(index));
                }
                obj = new ArrayAccess(name, indexes);
            }else{
                obj = new VarAccess(name);
            }
            return new VarRef(getLocation(ctx), obj);
        }
        return visit(ctx.name);
    }

    @Override
    public Tree visitPrintStatement(PrintStatementContext ctx) {
        var args = ctx.expr()
                /* Take all the parsed arguments, ... */
                .stream()
                /* ... visit them using this visitor, ... */
                .map(this::visit)
                /* ... then cast them to expressions, ...  */
                .map(x -> (Expr) x)
                /* ... and put them into a list.  */
                .toList();
        return new PrintStmt(getLocation(ctx), args);
    }

    @Override
    public Tree visitInputStatement(InputStatementContext ctx) {
        // Extract the string argument
        String prompt = ctx.STRING().getText();
        // Remove surrounding quotes from the string
        prompt = prompt.substring(1, prompt.length() - 1);

        return new InputStmt(getLocation(ctx), prompt);
    }

    @Override
    public Tree visitReturnStatement(ReturnStatementContext ctx) {
        // Visit the expression to be returned
        Expr returnValue = (Expr) visit(ctx.expr());
        return new ReturnStmt(getLocation(ctx), returnValue);
    }

    @Override
    public Tree visitIfStatement(IfStatementContext ctx) {
        // Process the logical expression (which can contain multiple conditions)
        List<Expr> conditions = new ArrayList<>();
        conditions.add((Expr) visit(ctx.logicalExpr())); // first condition

        // Handle additional conditions if present (connected by AND/OR)
        if (ctx.logicalExpr().logOp != null && !ctx.logicalExpr().logOp.isEmpty()) {
            for (int i = 0; i < ctx.logicalExpr().logOp.size(); i++) {
                // visit the right-hand side condition
                Expr rightCondition = (Expr) visit(ctx.logicalExpr().right.get(i));
                conditions.add(rightCondition);
            }
        }

        // Process the "if" block
        List<Statement> ifBody = ctx.ifBlock != null
                ? ctx.ifBlock.stream().map(stmtCtx -> (Statement) visit(stmtCtx)).toList()
                : new ArrayList<>();
        Block ifBlock = new Block(getLocation(ctx), ifBody);

        // Process the "else" block (if present)
        List<Statement> elseBody = ctx.elseBlock != null
                ? ctx.elseBlock.stream().map(stmtCtx -> (Statement) visit(stmtCtx)).toList()
                : new ArrayList<>();
        Block elseBlock = new Block(getLocation(ctx), elseBody);

        return new IfStmt(getLocation(ctx), conditions, ifBlock, elseBlock);
    }





    @Override
    public Tree visitWhileStatement(WhileStatementContext ctx) {
        // Process the logical expression (which can contain multiple conditions)
        List<Expr> conditions = new ArrayList<>();
        conditions.add((Expr) visit(ctx.logicalExpr().left)); // first condition

        // Handle additional conditions if present (connected by AND/OR)
        if (ctx.logicalExpr().logOp != null && !ctx.logicalExpr().logOp.isEmpty()) {
            for (int i = 0; i < ctx.logicalExpr().logOp.size(); i++) {
                // visit the right-hand side condition
                Expr rightCondition = (Expr) visit(ctx.logicalExpr().right.get(i));
                conditions.add(rightCondition);
            }
        }

        // Process the body of the while loop
        List<Statement> body = new ArrayList<>();
        if (ctx.block().statement() != null) {
            for (StatementContext stmtCtx : ctx.block().statement()) {
                body.add((Statement) visit(stmtCtx));
            }
        }
        Block block = new Block(getLocation(ctx.block()), body);

        return new WhileStmt(getLocation(ctx), conditions, block);
    }




    @Override
    public Tree visitForStatement(ForStatementContext ctx) {
        Declaration initializer = ctx.declaration() != null ? (Declaration) visit(ctx.declaration()) : null;

        Expr condition = ctx.comparisonExpr() != null ? (Expr) visit(ctx.comparisonExpr()) : null;

        Expr updater = ctx.incrementExpr() != null ? (Expr) visit(ctx.incrementExpr()) : null;

        List<Statement> body = new ArrayList<>();
        if(ctx.block().statement() != null){
            for(StatementContext stmtCtx : ctx.block().statement()){
                body.add((Statement) visit(stmtCtx));
            }
        }
        Block block = new Block(getLocation(ctx.block()), body);

        return new ForStmt(getLocation(ctx), initializer, condition, updater, block);
    }



    @Override
    public Tree visitFunctionStatement(FunctionStatementContext ctx) {
        String typeString = visit(ctx.type()).toString();
        Type type = convertType(ctx.type());

        VarAccess name = new VarAccess(ctx.IDENTIFIER().getText());

        List<Declaration> parameters = new ArrayList<>();
        if (ctx.declaration() != null) {
            for (DeclarationContext declCtx : ctx.declaration()) {
                Declaration declaration = (Declaration) visit(declCtx);
                declaration.setDeclaredType(convertType(declCtx.type()));
                parameters.add(declaration);
            }
        }

        List<Statement> body = new ArrayList<>();
        if (ctx.block() != null) {
            for (StatementContext stmtCtx : ctx.block().statement()) {
                body.add((Statement) visit(stmtCtx));
            }
        }

        Block block = new Block(getLocation(ctx.block()), body);

        return new FunctionStmt(getLocation(ctx), name, type, parameters, block, type);
    }

    @Override
    public Tree visitFunctionCall(FunctionCallContext ctx) {
        String name = ctx.IDENTIFIER().getText(); // Extract function name
        List<Expr> arguments = new ArrayList<>();

        // Parse arguments if present
        if (ctx.expr() != null) {
            for (var exprCtx : ctx.expr()) {
                // Visit each argument expression and add it to the list
                arguments.add((Expr) visit(exprCtx));
            }
        }

        // Return a new FunctionCall node
        return new FunctionCall(getLocation(ctx), name, arguments);
    }



    @Override
    public Expr visitIncrementExpr(IncrementExprContext ctx) {
        // Extract the name of the variable from the IDENTIFIER
        String variableName = ctx.IDENTIFIER().getText();

        // Create a VarAccess for the variable
        VarAccess varAccess = new VarAccess(variableName);

        // Create a VarRef for the variable
        VarRef variable = new VarRef(getLocation(ctx.IDENTIFIER()), varAccess);

        // Check if the operation is increment (++) or decrement (--)
        boolean isIncrement = ctx.PLUS_PLUS() != null;

        // Return an IncrementExpr node
        return new IncrementExpr(getLocation(ctx), variable, isIncrement);
    }



    @Override
    public Tree visitExpr(ExprContext ctx) {
        return (Expr) visit(ctx.logicalExpr());
    }


    @Override
    public Expr visitLogicalExpr(LogicalExprContext ctx) {
        if (ctx.logOp == null || ctx.logOp.isEmpty()) {
            return (Expr) visit(ctx.left); // Return the single expression if no operators exist
        }

        Expr left = (Expr) visit(ctx.left);
        List<Expr> right = ctx.right.stream().map(this::visit).map(e -> (Expr) e).toList();

        // Convert strings to Operations using the `Operation` enum
        List<Expr.Operation> operators = ctx.logOp.stream()
                .map(Token::getText)
                .map(op -> switch (op) {
                    case "and" -> Expr.Operation.AND;
                    case "or" -> Expr.Operation.OR;
                    default -> throw new IllegalArgumentException("Invalid logical operator: " + op);
                })
                .toList();

        return new LogicalExpr(getLocation(ctx), left, operators, right);
    }


    @Override
    public Expr visitComparisonExpr(ComparisonExprContext ctx) {
        if (ctx.operators == null || ctx.operators.isEmpty()) {
            return (Expr) visit(ctx.left);
        }

        Expr left = (Expr) visit(ctx.left);

        List<Expr> right = ctx.right.stream().map(this::visit).map(e -> (Expr) e).collect(Collectors.toList());

        List<Expr.Operation> operators = ctx.operators.stream()
                .map(Token::getText)
                .map(op -> switch (op) {
                    case "<" -> Expr.Operation.LESS;
                    case ">" -> Expr.Operation.GREATER;
                    case "<=" -> Expr.Operation.LESS_EQUAL;
                    case ">=" -> Expr.Operation.GREATER_EQUAL;
                    case "==" -> Expr.Operation.EQUAL_EQUAL;
                    case "!=" -> Expr.Operation.NOT_EQUAL;
                    default -> throw new IllegalArgumentException("Invalid comparison operator: " + op);
                })
                .collect(Collectors.toList());

        return new ComparisonExpr(getLocation(ctx), left, operators, right);
    }


    @Override
    public Tree visitAdditionExpr(AdditionExprContext ctx) {
        var value = (Expr) visit(ctx.initial);

        assert ctx.op.size() == ctx.rest.size();
        for (int i = 0; i < ctx.op.size(); i++) {
            var op = ctx.op.get(i);
            var rhs = (Expr) visit(ctx.rest.get(i));

            var exprOp = switch (op.getType()) {
                case SnackScriptLexer.PLUS -> Expr.Operation.ADD;
                case SnackScriptLexer.MINUS -> Expr.Operation.SUB;
                default -> throw new IllegalArgumentException("unhandled expr op " + op);
            };

            /* For an expression A+B+C, the location spanning A+B is the
               location from the start of A to the end of B, which will
               conveniently be created by
               {@code A.getLocation().span(b.getLocation())}.  */
            var loc = value.getLocation().span(rhs.getLocation());
            value = new Expr(loc, exprOp, value, rhs);
        }
        return value;
    }

    @Override
    public Tree visitMultiplicationExpr(MultiplicationExprContext ctx) {
        var value = (Expr) visit(ctx.initial);

        assert ctx.op.size() == ctx.rest.size();
        for (int i = 0; i < ctx.op.size(); i++) {
            var op = ctx.op.get(i);
            var rhs = (Expr) visit(ctx.rest.get(i));

            /* This part changed, I guess.  */
            var exprOp = switch (op.getType()) {
                case SnackScriptLexer.STAR -> Expr.Operation.MUL;
                case SnackScriptLexer.SLASH -> Expr.Operation.DIV;
                default -> throw new IllegalArgumentException("unhandled expr op " + op);
            };

            var loc = value.getLocation().span(rhs.getLocation());
            value = new Expr(loc, exprOp, value, rhs);
        }
        return value;
    }

    @Override
    public Tree visitExponentExpr(ExponentExprContext ctx) {
        var lhs = (Expr) visit(ctx.lhs);
        if (ctx.rhs == null)
            return lhs;

        var rhs = (Expr) visit(ctx.rhs);
        return new Expr(lhs.getLocation().span(rhs.getLocation()),
                Expr.Operation.POW, lhs, rhs);
    }

    @Override
    public Tree visitNumberConstant(NumberConstantContext ctx) {
        return new NumberLit(getLocation(ctx), Double.parseDouble(ctx.getText()));
    }

    @Override
    public Tree visitVariableReference(VariableReferenceContext ctx) {
        VarRef name = (VarRef) ctx.IDENTIFIER();
        return new VarRef(getLocation(ctx), name.getVarName());
    }

    @Override
    public Tree visitGroupingOperator(GroupingOperatorContext ctx) {
        return (Expr) visit(ctx.expr());
    }

    @Override
    public Tree visitArrayConstructor(ArrayConstructorContext ctx) {
        return (Expr) visit(ctx.arrayLiteral());
    }

    @Override
    public Tree visitStringLiteral(StringLiteralContext ctx) {
        String value = ctx.STRING().getText();
        value = value.substring(1, value.length() - 1);

        Location location = getLocation(ctx);

        return new StringExpr(location, value);
    }

    @Override
    public Tree visitTrueLiteral(TrueLiteralContext ctx) {
        return new BoolExpr(getLocation(ctx), true);
    }

    @Override
    public Tree visitFalseLiteral(FalseLiteralContext ctx) {
        return new BoolExpr(getLocation(ctx), false);
    }

    @Override
    public Tree visitFunCall(FunCallContext ctx) {
        return (Expr) visit(ctx.functionCall());
    }

    @Override
    public Tree visitArrayLiteral(ArrayLiteralContext ctx) {
        var args = ctx.expr()
                /* Take all the parsed arguments, ... */
                .stream()
                /* ... visit them using this visitor, ... */
                .map(this::visit)
                /* ... then cast them to expressions, ...  */
                .map(x -> (Expr) x)
                /* ... and put them into a list.  */
                .toList();
        return new ArrayExpr(getLocation(ctx), args);
    }

    @Override
    public Tree visitIntType(IntTypeContext ctx) {
        if(ctx.NUM() != null){
            Location location = getLocation(ctx);
            return new TypeExpr(location, TypeExpr.TypeKind.NUM);
        }
        throw new IllegalArgumentException("Unknown base type: " + ctx.getText());
    }

    @Override
    public Tree visitBoolType(BoolTypeContext ctx) {
        if(ctx.BOOL() != null){
            Location location = getLocation(ctx);
            return new TypeExpr(location, TypeExpr.TypeKind.BOOL);
        }
        throw new IllegalArgumentException("Unknown base type: " + ctx.getText());
    }

    @Override
    public Tree visitStringType(StringTypeContext ctx) {
        if(ctx.LINE() != null){
            Location location = getLocation(ctx);
            return new TypeExpr(location, TypeExpr.TypeKind.STRING);
        }
        throw new IllegalArgumentException("Unknown base type: " + ctx.getText());
    }

    @Override
    public Tree visitArray(ArrayContext ctx) {
        if(ctx.ARRAY() != null){
            Location location = getLocation(ctx);
            return new TypeExpr(location, TypeExpr.TypeKind.ARRAY);
        }
        throw new IllegalArgumentException("Unknown base type: " + ctx.getText());
    }

    @Override
    public Tree visitArrayType(ArrayTypeContext ctx) {
        if(ctx.ARRAY() != null){
            Location location = getLocation(ctx);
            return new TypeExpr(location, TypeExpr.TypeKind.ARRAY);
        }
        throw new IllegalArgumentException("Unknown base type: " + ctx.getText());
    }


    private Type convertType(TypeContext ctx){
        return switch(ctx){
            case  ArrayTypeContext array -> snackScript.listOfType(convertType(array.type()));
            case IntTypeContext num -> snackScript.getNumberType();
            case BoolTypeContext bool -> snackScript.getBooleanType();
            case StringTypeContext string -> snackScript.getStringType();
            default -> throw new IllegalArgumentException("Unknown type: " + ctx.getText());
        };
    }


}




