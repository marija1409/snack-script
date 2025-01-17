// Generated from snackScript/parser/SnackScript.g4 by ANTLR 4.13.0
package snackScript.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SnackScriptParser}.
 */
public interface SnackScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SnackScriptParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(SnackScriptParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnackScriptParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(SnackScriptParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnackScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SnackScriptParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnackScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SnackScriptParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnackScriptParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SnackScriptParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnackScriptParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SnackScriptParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnackScriptParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(SnackScriptParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnackScriptParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(SnackScriptParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnackScriptParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(SnackScriptParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnackScriptParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(SnackScriptParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnackScriptParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(SnackScriptParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnackScriptParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(SnackScriptParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnackScriptParser#inputStatement}.
	 * @param ctx the parse tree
	 */
	void enterInputStatement(SnackScriptParser.InputStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnackScriptParser#inputStatement}.
	 * @param ctx the parse tree
	 */
	void exitInputStatement(SnackScriptParser.InputStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnackScriptParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(SnackScriptParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnackScriptParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(SnackScriptParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnackScriptParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(SnackScriptParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnackScriptParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(SnackScriptParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnackScriptParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(SnackScriptParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnackScriptParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(SnackScriptParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnackScriptParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(SnackScriptParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnackScriptParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(SnackScriptParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnackScriptParser#functionStatement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionStatement(SnackScriptParser.FunctionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnackScriptParser#functionStatement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionStatement(SnackScriptParser.FunctionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnackScriptParser#incrementExpr}.
	 * @param ctx the parse tree
	 */
	void enterIncrementExpr(SnackScriptParser.IncrementExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnackScriptParser#incrementExpr}.
	 * @param ctx the parse tree
	 */
	void exitIncrementExpr(SnackScriptParser.IncrementExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnackScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SnackScriptParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnackScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SnackScriptParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnackScriptParser#logicalExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpr(SnackScriptParser.LogicalExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnackScriptParser#logicalExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpr(SnackScriptParser.LogicalExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnackScriptParser#comparisonExpr}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpr(SnackScriptParser.ComparisonExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnackScriptParser#comparisonExpr}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpr(SnackScriptParser.ComparisonExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnackScriptParser#additionExpr}.
	 * @param ctx the parse tree
	 */
	void enterAdditionExpr(SnackScriptParser.AdditionExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnackScriptParser#additionExpr}.
	 * @param ctx the parse tree
	 */
	void exitAdditionExpr(SnackScriptParser.AdditionExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnackScriptParser#multiplicationExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationExpr(SnackScriptParser.MultiplicationExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnackScriptParser#multiplicationExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationExpr(SnackScriptParser.MultiplicationExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnackScriptParser#exponentExpr}.
	 * @param ctx the parse tree
	 */
	void enterExponentExpr(SnackScriptParser.ExponentExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnackScriptParser#exponentExpr}.
	 * @param ctx the parse tree
	 */
	void exitExponentExpr(SnackScriptParser.ExponentExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnackScriptParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(SnackScriptParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnackScriptParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(SnackScriptParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberConstant}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNumberConstant(SnackScriptParser.NumberConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberConstant}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNumberConstant(SnackScriptParser.NumberConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableReference}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterVariableReference(SnackScriptParser.VariableReferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableReference}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitVariableReference(SnackScriptParser.VariableReferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GroupingOperator}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterGroupingOperator(SnackScriptParser.GroupingOperatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GroupingOperator}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitGroupingOperator(SnackScriptParser.GroupingOperatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayConstructor}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterArrayConstructor(SnackScriptParser.ArrayConstructorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayConstructor}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitArrayConstructor(SnackScriptParser.ArrayConstructorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(SnackScriptParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(SnackScriptParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrueLiteral}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterTrueLiteral(SnackScriptParser.TrueLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrueLiteral}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitTrueLiteral(SnackScriptParser.TrueLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FalseLiteral}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterFalseLiteral(SnackScriptParser.FalseLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FalseLiteral}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitFalseLiteral(SnackScriptParser.FalseLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunCall}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterFunCall(SnackScriptParser.FunCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunCall}
	 * labeled alternative in {@link SnackScriptParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitFunCall(SnackScriptParser.FunCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnackScriptParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(SnackScriptParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnackScriptParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(SnackScriptParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SnackScriptParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(SnackScriptParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SnackScriptParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(SnackScriptParser.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link SnackScriptParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntType(SnackScriptParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link SnackScriptParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntType(SnackScriptParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link SnackScriptParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(SnackScriptParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link SnackScriptParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(SnackScriptParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringType}
	 * labeled alternative in {@link SnackScriptParser#type}.
	 * @param ctx the parse tree
	 */
	void enterStringType(SnackScriptParser.StringTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringType}
	 * labeled alternative in {@link SnackScriptParser#type}.
	 * @param ctx the parse tree
	 */
	void exitStringType(SnackScriptParser.StringTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code array}
	 * labeled alternative in {@link SnackScriptParser#type}.
	 * @param ctx the parse tree
	 */
	void enterArray(SnackScriptParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code array}
	 * labeled alternative in {@link SnackScriptParser#type}.
	 * @param ctx the parse tree
	 */
	void exitArray(SnackScriptParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link SnackScriptParser#type}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(SnackScriptParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link SnackScriptParser#type}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(SnackScriptParser.ArrayTypeContext ctx);
}