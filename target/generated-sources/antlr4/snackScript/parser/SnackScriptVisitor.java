// Generated from snackScript/parser/SnackScript.g4 by ANTLR 4.13.0
package snackScript.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SnackScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SnackScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SnackScriptParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(SnackScriptParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnackScriptParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SnackScriptParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnackScriptParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SnackScriptParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnackScriptParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(SnackScriptParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnackScriptParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(SnackScriptParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnackScriptParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(SnackScriptParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnackScriptParser#inputStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputStatement(SnackScriptParser.InputStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnackScriptParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(SnackScriptParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnackScriptParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(SnackScriptParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnackScriptParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(SnackScriptParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnackScriptParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(SnackScriptParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnackScriptParser#functionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionStatement(SnackScriptParser.FunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnackScriptParser#incrementExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrementExpr(SnackScriptParser.IncrementExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnackScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(SnackScriptParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnackScriptParser#logicalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpr(SnackScriptParser.LogicalExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnackScriptParser#comparisonExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpr(SnackScriptParser.ComparisonExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnackScriptParser#additionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionExpr(SnackScriptParser.AdditionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnackScriptParser#multiplicationExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpr(SnackScriptParser.MultiplicationExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnackScriptParser#exponentExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExponentExpr(SnackScriptParser.ExponentExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnackScriptParser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(SnackScriptParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberConstant}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberConstant(SnackScriptParser.NumberConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableReference}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableReference(SnackScriptParser.VariableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GroupingOperator}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupingOperator(SnackScriptParser.GroupingOperatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayConstructor}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayConstructor(SnackScriptParser.ArrayConstructorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(SnackScriptParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrueLiteral}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueLiteral(SnackScriptParser.TrueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FalseLiteral}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseLiteral(SnackScriptParser.FalseLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunCall}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunCall(SnackScriptParser.FunCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnackScriptParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(SnackScriptParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SnackScriptParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(SnackScriptParser.ArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link SnackScriptParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(SnackScriptParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link SnackScriptParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(SnackScriptParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringType}
	 * labeled alternative in {@link SnackScriptParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringType(SnackScriptParser.StringTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code array}
	 * labeled alternative in {@link SnackScriptParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(SnackScriptParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link SnackScriptParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(SnackScriptParser.ArrayTypeContext ctx);
}