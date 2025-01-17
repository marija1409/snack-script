// Generated from snackScript/parser/SnackScript.g4 by ANTLR 4.13.0
package snackScript.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SnackScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, STRING=5, TRUE=6, FALSE=7, NUM=8, BOOL=9, 
		LINE=10, ARRAY=11, PRINT=12, INPUT=13, IF=14, ELSE=15, WHILE=16, FOR=17, 
		FUN=18, RETURN=19, AND=20, OR=21, LEFT_PAREN=22, RIGHT_PAREN=23, CARET=24, 
		STAR=25, SLASH=26, PLUS=27, MINUS=28, ARRAY_OPEN=29, ARRAY_CLOSE=30, COMMA=31, 
		EQUAL=32, LESS=33, GREATER=34, LESS_EQUAL=35, GREATER_EQUAL=36, EQUAL_EQUAL=37, 
		NOT_EQUAL=38, PLUS_PLUS=39, MINUS_MINUS=40, NUMBER=41, IDENTIFIER=42, 
		SPACES=43, COMMENT=44, LINE_COMMENT=45;
	public static final int
		RULE_start = 0, RULE_statement = 1, RULE_block = 2, RULE_declaration = 3, 
		RULE_assign = 4, RULE_printStatement = 5, RULE_inputStatement = 6, RULE_returnStatement = 7, 
		RULE_ifStatement = 8, RULE_whileStatement = 9, RULE_forStatement = 10, 
		RULE_functionStatement = 11, RULE_incrementExpr = 12, RULE_expr = 13, 
		RULE_logicalExpr = 14, RULE_comparisonExpr = 15, RULE_additionExpr = 16, 
		RULE_multiplicationExpr = 17, RULE_exponentExpr = 18, RULE_arrayAccess = 19, 
		RULE_atom = 20, RULE_functionCall = 21, RULE_arrayLiteral = 22, RULE_type = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "statement", "block", "declaration", "assign", "printStatement", 
			"inputStatement", "returnStatement", "ifStatement", "whileStatement", 
			"forStatement", "functionStatement", "incrementExpr", "expr", "logicalExpr", 
			"comparisonExpr", "additionExpr", "multiplicationExpr", "exponentExpr", 
			"arrayAccess", "atom", "functionCall", "arrayLiteral", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'{'", "'}'", "'eat'", null, "'true'", "'false'", "'num'", 
			"'bool'", "'line'", "'bunch'", "'spit'", "'input'", "'check'", "'ohwell'", 
			"'until'", "'each'", "'fun'", "'vomit'", "'and'", "'or'", "'('", "')'", 
			"'^'", "'*'", "'/'", "'+'", "'-'", "'['", "']'", "','", "'='", "'<'", 
			"'>'", "'<='", "'>='", "'=='", "'!='", "'++'", "'--'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "STRING", "TRUE", "FALSE", "NUM", "BOOL", 
			"LINE", "ARRAY", "PRINT", "INPUT", "IF", "ELSE", "WHILE", "FOR", "FUN", 
			"RETURN", "AND", "OR", "LEFT_PAREN", "RIGHT_PAREN", "CARET", "STAR", 
			"SLASH", "PLUS", "MINUS", "ARRAY_OPEN", "ARRAY_CLOSE", "COMMA", "EQUAL", 
			"LESS", "GREATER", "LESS_EQUAL", "GREATER_EQUAL", "EQUAL_EQUAL", "NOT_EQUAL", 
			"PLUS_PLUS", "MINUS_MINUS", "NUMBER", "IDENTIFIER", "SPACES", "COMMENT", 
			"LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SnackScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SnackScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SnackScriptParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6597611585520L) != 0)) {
				{
				{
				setState(48);
				statement();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InputStatementContext inputStatement() {
			return getRuleContext(InputStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public FunctionStatementContext functionStatement() {
			return getRuleContext(FunctionStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				declaration();
				setState(57);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				assign();
				setState(60);
				match(T__0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				printStatement();
				setState(63);
				match(T__0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				expr();
				setState(66);
				match(T__0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(68);
				inputStatement();
				setState(69);
				match(T__0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(71);
				ifStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(72);
				whileStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(73);
				forStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(74);
				functionStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(75);
				returnStatement();
				setState(76);
				match(T__0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__1);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6597611585520L) != 0)) {
				{
				{
				setState(81);
				statement();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(SnackScriptParser.IDENTIFIER, 0); }
		public TerminalNode EQUAL() { return getToken(SnackScriptParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaration);
		try {
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				type();
				setState(90);
				match(IDENTIFIER);
				setState(91);
				match(EQUAL);
				setState(92);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				type();
				setState(95);
				match(IDENTIFIER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				type();
				setState(98);
				match(IDENTIFIER);
				setState(99);
				match(EQUAL);
				setState(100);
				arrayLiteral();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ParserRuleContext {
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(SnackScriptParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			arrayAccess();
			setState(105);
			match(EQUAL);
			setState(106);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintStatementContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(SnackScriptParser.PRINT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SnackScriptParser.LEFT_PAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SnackScriptParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SnackScriptParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SnackScriptParser.COMMA, i);
		}
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitPrintStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitPrintStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_printStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(PRINT);
			setState(109);
			match(LEFT_PAREN);
			setState(110);
			expr();
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(111);
				match(COMMA);
				setState(112);
				expr();
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InputStatementContext extends ParserRuleContext {
		public TerminalNode INPUT() { return getToken(SnackScriptParser.INPUT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SnackScriptParser.LEFT_PAREN, 0); }
		public TerminalNode STRING() { return getToken(SnackScriptParser.STRING, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SnackScriptParser.RIGHT_PAREN, 0); }
		public InputStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterInputStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitInputStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitInputStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputStatementContext inputStatement() throws RecognitionException {
		InputStatementContext _localctx = new InputStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_inputStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(INPUT);
			setState(121);
			match(LEFT_PAREN);
			setState(122);
			match(STRING);
			setState(123);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(SnackScriptParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(RETURN);
			setState(126);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public StatementContext statement;
		public List<StatementContext> ifBlock = new ArrayList<StatementContext>();
		public List<StatementContext> elseBlock = new ArrayList<StatementContext>();
		public TerminalNode IF() { return getToken(SnackScriptParser.IF, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SnackScriptParser.LEFT_PAREN, 0); }
		public LogicalExprContext logicalExpr() {
			return getRuleContext(LogicalExprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SnackScriptParser.RIGHT_PAREN, 0); }
		public TerminalNode ELSE() { return getToken(SnackScriptParser.ELSE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(IF);
			setState(129);
			match(LEFT_PAREN);
			setState(130);
			logicalExpr();
			setState(131);
			match(RIGHT_PAREN);
			setState(132);
			match(T__1);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6597611585520L) != 0)) {
				{
				{
				setState(133);
				((IfStatementContext)_localctx).statement = statement();
				((IfStatementContext)_localctx).ifBlock.add(((IfStatementContext)_localctx).statement);
				}
				}
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(139);
			match(T__2);
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(140);
				match(ELSE);
				setState(141);
				match(T__1);
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6597611585520L) != 0)) {
					{
					{
					setState(142);
					((IfStatementContext)_localctx).statement = statement();
					((IfStatementContext)_localctx).elseBlock.add(((IfStatementContext)_localctx).statement);
					}
					}
					setState(147);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(148);
				match(T__2);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(SnackScriptParser.WHILE, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SnackScriptParser.LEFT_PAREN, 0); }
		public LogicalExprContext logicalExpr() {
			return getRuleContext(LogicalExprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SnackScriptParser.RIGHT_PAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(WHILE);
			setState(152);
			match(LEFT_PAREN);
			setState(153);
			logicalExpr();
			setState(154);
			match(RIGHT_PAREN);
			setState(155);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(SnackScriptParser.FOR, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SnackScriptParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SnackScriptParser.RIGHT_PAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ComparisonExprContext comparisonExpr() {
			return getRuleContext(ComparisonExprContext.class,0);
		}
		public IncrementExprContext incrementExpr() {
			return getRuleContext(IncrementExprContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(FOR);
			setState(158);
			match(LEFT_PAREN);
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3840L) != 0)) {
				{
				setState(159);
				declaration();
				}
			}

			setState(162);
			match(T__0);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6597610832112L) != 0)) {
				{
				setState(163);
				comparisonExpr();
				}
			}

			setState(166);
			match(T__0);
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(167);
				incrementExpr();
				}
			}

			setState(170);
			match(RIGHT_PAREN);
			setState(171);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionStatementContext extends ParserRuleContext {
		public TypeContext tip;
		public TerminalNode FUN() { return getToken(SnackScriptParser.FUN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SnackScriptParser.IDENTIFIER, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SnackScriptParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SnackScriptParser.RIGHT_PAREN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SnackScriptParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SnackScriptParser.COMMA, i);
		}
		public FunctionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterFunctionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitFunctionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitFunctionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionStatementContext functionStatement() throws RecognitionException {
		FunctionStatementContext _localctx = new FunctionStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			((FunctionStatementContext)_localctx).tip = type();
			setState(174);
			match(FUN);
			setState(175);
			match(IDENTIFIER);
			setState(176);
			match(LEFT_PAREN);
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3840L) != 0)) {
				{
				setState(177);
				declaration();
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(178);
					match(COMMA);
					setState(179);
					declaration();
					}
					}
					setState(184);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(187);
			match(RIGHT_PAREN);
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(188);
				block();
				}
				break;
			case T__0:
				{
				setState(189);
				match(T__0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IncrementExprContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SnackScriptParser.IDENTIFIER, 0); }
		public TerminalNode PLUS_PLUS() { return getToken(SnackScriptParser.PLUS_PLUS, 0); }
		public TerminalNode MINUS_MINUS() { return getToken(SnackScriptParser.MINUS_MINUS, 0); }
		public IncrementExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incrementExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterIncrementExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitIncrementExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitIncrementExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncrementExprContext incrementExpr() throws RecognitionException {
		IncrementExprContext _localctx = new IncrementExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_incrementExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(IDENTIFIER);
			setState(193);
			_la = _input.LA(1);
			if ( !(_la==PLUS_PLUS || _la==MINUS_MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public LogicalExprContext logicalExpr() {
			return getRuleContext(LogicalExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			logicalExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalExprContext extends ParserRuleContext {
		public ComparisonExprContext left;
		public Token AND;
		public List<Token> logOp = new ArrayList<Token>();
		public Token OR;
		public Token _tset343;
		public ComparisonExprContext comparisonExpr;
		public List<ComparisonExprContext> right = new ArrayList<ComparisonExprContext>();
		public List<ComparisonExprContext> comparisonExpr() {
			return getRuleContexts(ComparisonExprContext.class);
		}
		public ComparisonExprContext comparisonExpr(int i) {
			return getRuleContext(ComparisonExprContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(SnackScriptParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(SnackScriptParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(SnackScriptParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(SnackScriptParser.OR, i);
		}
		public LogicalExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterLogicalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitLogicalExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitLogicalExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalExprContext logicalExpr() throws RecognitionException {
		LogicalExprContext _localctx = new LogicalExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_logicalExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			((LogicalExprContext)_localctx).left = comparisonExpr();
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(198);
				((LogicalExprContext)_localctx)._tset343 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==AND || _la==OR) ) {
					((LogicalExprContext)_localctx)._tset343 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((LogicalExprContext)_localctx).logOp.add(((LogicalExprContext)_localctx)._tset343);
				setState(199);
				((LogicalExprContext)_localctx).comparisonExpr = comparisonExpr();
				((LogicalExprContext)_localctx).right.add(((LogicalExprContext)_localctx).comparisonExpr);
				}
				}
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonExprContext extends ParserRuleContext {
		public AdditionExprContext left;
		public Token LESS;
		public List<Token> operators = new ArrayList<Token>();
		public Token GREATER;
		public Token LESS_EQUAL;
		public Token GREATER_EQUAL;
		public Token EQUAL_EQUAL;
		public Token NOT_EQUAL;
		public Token _tset371;
		public AdditionExprContext additionExpr;
		public List<AdditionExprContext> right = new ArrayList<AdditionExprContext>();
		public List<AdditionExprContext> additionExpr() {
			return getRuleContexts(AdditionExprContext.class);
		}
		public AdditionExprContext additionExpr(int i) {
			return getRuleContext(AdditionExprContext.class,i);
		}
		public List<TerminalNode> LESS() { return getTokens(SnackScriptParser.LESS); }
		public TerminalNode LESS(int i) {
			return getToken(SnackScriptParser.LESS, i);
		}
		public List<TerminalNode> GREATER() { return getTokens(SnackScriptParser.GREATER); }
		public TerminalNode GREATER(int i) {
			return getToken(SnackScriptParser.GREATER, i);
		}
		public List<TerminalNode> LESS_EQUAL() { return getTokens(SnackScriptParser.LESS_EQUAL); }
		public TerminalNode LESS_EQUAL(int i) {
			return getToken(SnackScriptParser.LESS_EQUAL, i);
		}
		public List<TerminalNode> GREATER_EQUAL() { return getTokens(SnackScriptParser.GREATER_EQUAL); }
		public TerminalNode GREATER_EQUAL(int i) {
			return getToken(SnackScriptParser.GREATER_EQUAL, i);
		}
		public List<TerminalNode> EQUAL_EQUAL() { return getTokens(SnackScriptParser.EQUAL_EQUAL); }
		public TerminalNode EQUAL_EQUAL(int i) {
			return getToken(SnackScriptParser.EQUAL_EQUAL, i);
		}
		public List<TerminalNode> NOT_EQUAL() { return getTokens(SnackScriptParser.NOT_EQUAL); }
		public TerminalNode NOT_EQUAL(int i) {
			return getToken(SnackScriptParser.NOT_EQUAL, i);
		}
		public ComparisonExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterComparisonExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitComparisonExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitComparisonExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonExprContext comparisonExpr() throws RecognitionException {
		ComparisonExprContext _localctx = new ComparisonExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_comparisonExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			((ComparisonExprContext)_localctx).left = additionExpr();
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 541165879296L) != 0)) {
				{
				{
				setState(206);
				((ComparisonExprContext)_localctx)._tset371 = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 541165879296L) != 0)) ) {
					((ComparisonExprContext)_localctx)._tset371 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((ComparisonExprContext)_localctx).operators.add(((ComparisonExprContext)_localctx)._tset371);
				setState(207);
				((ComparisonExprContext)_localctx).additionExpr = additionExpr();
				((ComparisonExprContext)_localctx).right.add(((ComparisonExprContext)_localctx).additionExpr);
				}
				}
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditionExprContext extends ParserRuleContext {
		public MultiplicationExprContext initial;
		public Token PLUS;
		public List<Token> op = new ArrayList<Token>();
		public Token MINUS;
		public Token _tset414;
		public MultiplicationExprContext multiplicationExpr;
		public List<MultiplicationExprContext> rest = new ArrayList<MultiplicationExprContext>();
		public List<MultiplicationExprContext> multiplicationExpr() {
			return getRuleContexts(MultiplicationExprContext.class);
		}
		public MultiplicationExprContext multiplicationExpr(int i) {
			return getRuleContext(MultiplicationExprContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(SnackScriptParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(SnackScriptParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(SnackScriptParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(SnackScriptParser.MINUS, i);
		}
		public AdditionExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additionExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterAdditionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitAdditionExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitAdditionExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditionExprContext additionExpr() throws RecognitionException {
		AdditionExprContext _localctx = new AdditionExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_additionExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			((AdditionExprContext)_localctx).initial = multiplicationExpr();
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(214);
				((AdditionExprContext)_localctx)._tset414 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((AdditionExprContext)_localctx)._tset414 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((AdditionExprContext)_localctx).op.add(((AdditionExprContext)_localctx)._tset414);
				setState(215);
				((AdditionExprContext)_localctx).multiplicationExpr = multiplicationExpr();
				((AdditionExprContext)_localctx).rest.add(((AdditionExprContext)_localctx).multiplicationExpr);
				}
				}
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicationExprContext extends ParserRuleContext {
		public ExponentExprContext initial;
		public Token STAR;
		public List<Token> op = new ArrayList<Token>();
		public Token SLASH;
		public Token _tset440;
		public ExponentExprContext exponentExpr;
		public List<ExponentExprContext> rest = new ArrayList<ExponentExprContext>();
		public List<ExponentExprContext> exponentExpr() {
			return getRuleContexts(ExponentExprContext.class);
		}
		public ExponentExprContext exponentExpr(int i) {
			return getRuleContext(ExponentExprContext.class,i);
		}
		public List<TerminalNode> STAR() { return getTokens(SnackScriptParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(SnackScriptParser.STAR, i);
		}
		public List<TerminalNode> SLASH() { return getTokens(SnackScriptParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(SnackScriptParser.SLASH, i);
		}
		public MultiplicationExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicationExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterMultiplicationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitMultiplicationExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitMultiplicationExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicationExprContext multiplicationExpr() throws RecognitionException {
		MultiplicationExprContext _localctx = new MultiplicationExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_multiplicationExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			((MultiplicationExprContext)_localctx).initial = exponentExpr();
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STAR || _la==SLASH) {
				{
				{
				setState(222);
				((MultiplicationExprContext)_localctx)._tset440 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==STAR || _la==SLASH) ) {
					((MultiplicationExprContext)_localctx)._tset440 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((MultiplicationExprContext)_localctx).op.add(((MultiplicationExprContext)_localctx)._tset440);
				setState(223);
				((MultiplicationExprContext)_localctx).exponentExpr = exponentExpr();
				((MultiplicationExprContext)_localctx).rest.add(((MultiplicationExprContext)_localctx).exponentExpr);
				}
				}
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExponentExprContext extends ParserRuleContext {
		public ArrayAccessContext lhs;
		public ExponentExprContext rhs;
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public TerminalNode CARET() { return getToken(SnackScriptParser.CARET, 0); }
		public ExponentExprContext exponentExpr() {
			return getRuleContext(ExponentExprContext.class,0);
		}
		public ExponentExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exponentExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterExponentExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitExponentExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitExponentExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExponentExprContext exponentExpr() throws RecognitionException {
		ExponentExprContext _localctx = new ExponentExprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_exponentExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			((ExponentExprContext)_localctx).lhs = arrayAccess();
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CARET) {
				{
				setState(230);
				match(CARET);
				setState(231);
				((ExponentExprContext)_localctx).rhs = exponentExpr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayAccessContext extends ParserRuleContext {
		public AtomContext name;
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public List<TerminalNode> ARRAY_OPEN() { return getTokens(SnackScriptParser.ARRAY_OPEN); }
		public TerminalNode ARRAY_OPEN(int i) {
			return getToken(SnackScriptParser.ARRAY_OPEN, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> ARRAY_CLOSE() { return getTokens(SnackScriptParser.ARRAY_CLOSE); }
		public TerminalNode ARRAY_CLOSE(int i) {
			return getToken(SnackScriptParser.ARRAY_CLOSE, i);
		}
		public ArrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterArrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitArrayAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitArrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayAccessContext arrayAccess() throws RecognitionException {
		ArrayAccessContext _localctx = new ArrayAccessContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_arrayAccess);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			((ArrayAccessContext)_localctx).name = atom();
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ARRAY_OPEN) {
				{
				{
				setState(235);
				match(ARRAY_OPEN);
				setState(236);
				expr();
				setState(237);
				match(ARRAY_CLOSE);
				}
				}
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GroupingOperatorContext extends AtomContext {
		public TerminalNode LEFT_PAREN() { return getToken(SnackScriptParser.LEFT_PAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SnackScriptParser.RIGHT_PAREN, 0); }
		public GroupingOperatorContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterGroupingOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitGroupingOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitGroupingOperator(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableReferenceContext extends AtomContext {
		public TerminalNode IDENTIFIER() { return getToken(SnackScriptParser.IDENTIFIER, 0); }
		public VariableReferenceContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterVariableReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitVariableReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitVariableReference(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringLiteralContext extends AtomContext {
		public TerminalNode STRING() { return getToken(SnackScriptParser.STRING, 0); }
		public StringLiteralContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueLiteralContext extends AtomContext {
		public TerminalNode TRUE() { return getToken(SnackScriptParser.TRUE, 0); }
		public TrueLiteralContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterTrueLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitTrueLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitTrueLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunCallContext extends AtomContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunCallContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterFunCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitFunCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitFunCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberConstantContext extends AtomContext {
		public TerminalNode NUMBER() { return getToken(SnackScriptParser.NUMBER, 0); }
		public NumberConstantContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterNumberConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitNumberConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitNumberConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayConstructorContext extends AtomContext {
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public ArrayConstructorContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterArrayConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitArrayConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitArrayConstructor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseLiteralContext extends AtomContext {
		public TerminalNode FALSE() { return getToken(SnackScriptParser.FALSE, 0); }
		public FalseLiteralContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterFalseLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitFalseLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitFalseLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_atom);
		try {
			setState(255);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				_localctx = new NumberConstantContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				match(NUMBER);
				}
				break;
			case IDENTIFIER:
				_localctx = new VariableReferenceContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				match(IDENTIFIER);
				}
				break;
			case LEFT_PAREN:
				_localctx = new GroupingOperatorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(246);
				match(LEFT_PAREN);
				setState(247);
				expr();
				setState(248);
				match(RIGHT_PAREN);
				}
				break;
			case ARRAY_OPEN:
				_localctx = new ArrayConstructorContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(250);
				arrayLiteral();
				}
				break;
			case STRING:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(251);
				match(STRING);
				}
				break;
			case TRUE:
				_localctx = new TrueLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(252);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new FalseLiteralContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(253);
				match(FALSE);
				}
				break;
			case T__3:
				_localctx = new FunCallContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(254);
				functionCall();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SnackScriptParser.IDENTIFIER, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SnackScriptParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SnackScriptParser.RIGHT_PAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SnackScriptParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SnackScriptParser.COMMA, i);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(T__3);
			setState(258);
			match(IDENTIFIER);
			setState(259);
			match(LEFT_PAREN);
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6597610832112L) != 0)) {
				{
				setState(260);
				expr();
				setState(265);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(261);
					match(COMMA);
					setState(262);
					expr();
					}
					}
					setState(267);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(270);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayLiteralContext extends ParserRuleContext {
		public TerminalNode ARRAY_OPEN() { return getToken(SnackScriptParser.ARRAY_OPEN, 0); }
		public TerminalNode ARRAY_CLOSE() { return getToken(SnackScriptParser.ARRAY_CLOSE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SnackScriptParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SnackScriptParser.COMMA, i);
		}
		public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterArrayLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitArrayLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitArrayLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_arrayLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(ARRAY_OPEN);
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6597610832112L) != 0)) {
				{
				setState(273);
				expr();
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(274);
					match(COMMA);
					setState(275);
					expr();
					}
					}
					setState(280);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(283);
			match(ARRAY_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayTypeContext extends TypeContext {
		public TerminalNode ARRAY() { return getToken(SnackScriptParser.ARRAY, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArrayTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolTypeContext extends TypeContext {
		public TerminalNode BOOL() { return getToken(SnackScriptParser.BOOL, 0); }
		public BoolTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterBoolType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitBoolType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitBoolType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringTypeContext extends TypeContext {
		public TerminalNode LINE() { return getToken(SnackScriptParser.LINE, 0); }
		public StringTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterStringType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitStringType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitStringType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayContext extends TypeContext {
		public TerminalNode ARRAY() { return getToken(SnackScriptParser.ARRAY, 0); }
		public ArrayContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntTypeContext extends TypeContext {
		public TerminalNode NUM() { return getToken(SnackScriptParser.NUM, 0); }
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SnackScriptListener ) ((SnackScriptListener)listener).exitIntType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SnackScriptVisitor ) return ((SnackScriptVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_type);
		try {
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(285);
				match(NUM);
				}
				break;
			case 2:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
				match(BOOL);
				}
				break;
			case 3:
				_localctx = new StringTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(287);
				match(LINE);
				}
				break;
			case 4:
				_localctx = new ArrayContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(288);
				match(ARRAY);
				}
				break;
			case 5:
				_localctx = new ArrayTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(289);
				match(ARRAY);
				setState(290);
				type();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001-\u0126\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0005\u0000"+
		"2\b\u0000\n\u0000\f\u00005\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001O\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0005\u0002S\b\u0002\n\u0002\f\u0002V\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003g\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005r\b\u0005\n\u0005\f\u0005u\t\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0005\b\u0087\b\b\n\b\f\b\u008a\t\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0005\b\u0090\b\b\n\b\f\b\u0093\t\b\u0001\b\u0003\b\u0096\b\b"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u00a1\b\n\u0001\n\u0001\n\u0003\n\u00a5\b\n\u0001\n\u0001\n"+
		"\u0003\n\u00a9\b\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00b5"+
		"\b\u000b\n\u000b\f\u000b\u00b8\t\u000b\u0003\u000b\u00ba\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00bf\b\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e"+
		"\u00c9\b\u000e\n\u000e\f\u000e\u00cc\t\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0005\u000f\u00d1\b\u000f\n\u000f\f\u000f\u00d4\t\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0005\u0010\u00d9\b\u0010\n\u0010\f\u0010\u00dc"+
		"\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00e1\b\u0011"+
		"\n\u0011\f\u0011\u00e4\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003"+
		"\u0012\u00e9\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0005\u0013\u00f0\b\u0013\n\u0013\f\u0013\u00f3\t\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0100\b\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0005\u0015\u0108\b\u0015\n\u0015\f\u0015\u010b\t\u0015\u0003\u0015\u010d"+
		"\b\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0005\u0016\u0115\b\u0016\n\u0016\f\u0016\u0118\t\u0016\u0003\u0016"+
		"\u011a\b\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0124\b\u0017\u0001\u0017"+
		"\u0000\u0000\u0018\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*,.\u0000\u0005\u0001\u0000\'(\u0001"+
		"\u0000\u0014\u0015\u0001\u0000!&\u0001\u0000\u001b\u001c\u0001\u0000\u0019"+
		"\u001a\u0139\u00003\u0001\u0000\u0000\u0000\u0002N\u0001\u0000\u0000\u0000"+
		"\u0004P\u0001\u0000\u0000\u0000\u0006f\u0001\u0000\u0000\u0000\bh\u0001"+
		"\u0000\u0000\u0000\nl\u0001\u0000\u0000\u0000\fx\u0001\u0000\u0000\u0000"+
		"\u000e}\u0001\u0000\u0000\u0000\u0010\u0080\u0001\u0000\u0000\u0000\u0012"+
		"\u0097\u0001\u0000\u0000\u0000\u0014\u009d\u0001\u0000\u0000\u0000\u0016"+
		"\u00ad\u0001\u0000\u0000\u0000\u0018\u00c0\u0001\u0000\u0000\u0000\u001a"+
		"\u00c3\u0001\u0000\u0000\u0000\u001c\u00c5\u0001\u0000\u0000\u0000\u001e"+
		"\u00cd\u0001\u0000\u0000\u0000 \u00d5\u0001\u0000\u0000\u0000\"\u00dd"+
		"\u0001\u0000\u0000\u0000$\u00e5\u0001\u0000\u0000\u0000&\u00ea\u0001\u0000"+
		"\u0000\u0000(\u00ff\u0001\u0000\u0000\u0000*\u0101\u0001\u0000\u0000\u0000"+
		",\u0110\u0001\u0000\u0000\u0000.\u0123\u0001\u0000\u0000\u000002\u0003"+
		"\u0002\u0001\u000010\u0001\u0000\u0000\u000025\u0001\u0000\u0000\u0000"+
		"31\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000046\u0001\u0000\u0000"+
		"\u000053\u0001\u0000\u0000\u000067\u0005\u0000\u0000\u00017\u0001\u0001"+
		"\u0000\u0000\u000089\u0003\u0006\u0003\u00009:\u0005\u0001\u0000\u0000"+
		":O\u0001\u0000\u0000\u0000;<\u0003\b\u0004\u0000<=\u0005\u0001\u0000\u0000"+
		"=O\u0001\u0000\u0000\u0000>?\u0003\n\u0005\u0000?@\u0005\u0001\u0000\u0000"+
		"@O\u0001\u0000\u0000\u0000AB\u0003\u001a\r\u0000BC\u0005\u0001\u0000\u0000"+
		"CO\u0001\u0000\u0000\u0000DE\u0003\f\u0006\u0000EF\u0005\u0001\u0000\u0000"+
		"FO\u0001\u0000\u0000\u0000GO\u0003\u0010\b\u0000HO\u0003\u0012\t\u0000"+
		"IO\u0003\u0014\n\u0000JO\u0003\u0016\u000b\u0000KL\u0003\u000e\u0007\u0000"+
		"LM\u0005\u0001\u0000\u0000MO\u0001\u0000\u0000\u0000N8\u0001\u0000\u0000"+
		"\u0000N;\u0001\u0000\u0000\u0000N>\u0001\u0000\u0000\u0000NA\u0001\u0000"+
		"\u0000\u0000ND\u0001\u0000\u0000\u0000NG\u0001\u0000\u0000\u0000NH\u0001"+
		"\u0000\u0000\u0000NI\u0001\u0000\u0000\u0000NJ\u0001\u0000\u0000\u0000"+
		"NK\u0001\u0000\u0000\u0000O\u0003\u0001\u0000\u0000\u0000PT\u0005\u0002"+
		"\u0000\u0000QS\u0003\u0002\u0001\u0000RQ\u0001\u0000\u0000\u0000SV\u0001"+
		"\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000"+
		"UW\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000WX\u0005\u0003\u0000"+
		"\u0000X\u0005\u0001\u0000\u0000\u0000YZ\u0003.\u0017\u0000Z[\u0005*\u0000"+
		"\u0000[\\\u0005 \u0000\u0000\\]\u0003\u001a\r\u0000]g\u0001\u0000\u0000"+
		"\u0000^_\u0003.\u0017\u0000_`\u0005*\u0000\u0000`g\u0001\u0000\u0000\u0000"+
		"ab\u0003.\u0017\u0000bc\u0005*\u0000\u0000cd\u0005 \u0000\u0000de\u0003"+
		",\u0016\u0000eg\u0001\u0000\u0000\u0000fY\u0001\u0000\u0000\u0000f^\u0001"+
		"\u0000\u0000\u0000fa\u0001\u0000\u0000\u0000g\u0007\u0001\u0000\u0000"+
		"\u0000hi\u0003&\u0013\u0000ij\u0005 \u0000\u0000jk\u0003\u001a\r\u0000"+
		"k\t\u0001\u0000\u0000\u0000lm\u0005\f\u0000\u0000mn\u0005\u0016\u0000"+
		"\u0000ns\u0003\u001a\r\u0000op\u0005\u001f\u0000\u0000pr\u0003\u001a\r"+
		"\u0000qo\u0001\u0000\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000"+
		"\u0000\u0000st\u0001\u0000\u0000\u0000tv\u0001\u0000\u0000\u0000us\u0001"+
		"\u0000\u0000\u0000vw\u0005\u0017\u0000\u0000w\u000b\u0001\u0000\u0000"+
		"\u0000xy\u0005\r\u0000\u0000yz\u0005\u0016\u0000\u0000z{\u0005\u0005\u0000"+
		"\u0000{|\u0005\u0017\u0000\u0000|\r\u0001\u0000\u0000\u0000}~\u0005\u0013"+
		"\u0000\u0000~\u007f\u0003\u001a\r\u0000\u007f\u000f\u0001\u0000\u0000"+
		"\u0000\u0080\u0081\u0005\u000e\u0000\u0000\u0081\u0082\u0005\u0016\u0000"+
		"\u0000\u0082\u0083\u0003\u001c\u000e\u0000\u0083\u0084\u0005\u0017\u0000"+
		"\u0000\u0084\u0088\u0005\u0002\u0000\u0000\u0085\u0087\u0003\u0002\u0001"+
		"\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0087\u008a\u0001\u0000\u0000"+
		"\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000"+
		"\u0000\u0089\u008b\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000"+
		"\u0000\u008b\u0095\u0005\u0003\u0000\u0000\u008c\u008d\u0005\u000f\u0000"+
		"\u0000\u008d\u0091\u0005\u0002\u0000\u0000\u008e\u0090\u0003\u0002\u0001"+
		"\u0000\u008f\u008e\u0001\u0000\u0000\u0000\u0090\u0093\u0001\u0000\u0000"+
		"\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000"+
		"\u0000\u0092\u0094\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000"+
		"\u0000\u0094\u0096\u0005\u0003\u0000\u0000\u0095\u008c\u0001\u0000\u0000"+
		"\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0011\u0001\u0000\u0000"+
		"\u0000\u0097\u0098\u0005\u0010\u0000\u0000\u0098\u0099\u0005\u0016\u0000"+
		"\u0000\u0099\u009a\u0003\u001c\u000e\u0000\u009a\u009b\u0005\u0017\u0000"+
		"\u0000\u009b\u009c\u0003\u0004\u0002\u0000\u009c\u0013\u0001\u0000\u0000"+
		"\u0000\u009d\u009e\u0005\u0011\u0000\u0000\u009e\u00a0\u0005\u0016\u0000"+
		"\u0000\u009f\u00a1\u0003\u0006\u0003\u0000\u00a0\u009f\u0001\u0000\u0000"+
		"\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a4\u0005\u0001\u0000\u0000\u00a3\u00a5\u0003\u001e\u000f"+
		"\u0000\u00a4\u00a3\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a8\u0005\u0001\u0000"+
		"\u0000\u00a7\u00a9\u0003\u0018\f\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000"+
		"\u00aa\u00ab\u0005\u0017\u0000\u0000\u00ab\u00ac\u0003\u0004\u0002\u0000"+
		"\u00ac\u0015\u0001\u0000\u0000\u0000\u00ad\u00ae\u0003.\u0017\u0000\u00ae"+
		"\u00af\u0005\u0012\u0000\u0000\u00af\u00b0\u0005*\u0000\u0000\u00b0\u00b9"+
		"\u0005\u0016\u0000\u0000\u00b1\u00b6\u0003\u0006\u0003\u0000\u00b2\u00b3"+
		"\u0005\u001f\u0000\u0000\u00b3\u00b5\u0003\u0006\u0003\u0000\u00b4\u00b2"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b8\u0001\u0000\u0000\u0000\u00b6\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00ba"+
		"\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9\u00b1"+
		"\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bb"+
		"\u0001\u0000\u0000\u0000\u00bb\u00be\u0005\u0017\u0000\u0000\u00bc\u00bf"+
		"\u0003\u0004\u0002\u0000\u00bd\u00bf\u0005\u0001\u0000\u0000\u00be\u00bc"+
		"\u0001\u0000\u0000\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00bf\u0017"+
		"\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005*\u0000\u0000\u00c1\u00c2\u0007"+
		"\u0000\u0000\u0000\u00c2\u0019\u0001\u0000\u0000\u0000\u00c3\u00c4\u0003"+
		"\u001c\u000e\u0000\u00c4\u001b\u0001\u0000\u0000\u0000\u00c5\u00ca\u0003"+
		"\u001e\u000f\u0000\u00c6\u00c7\u0007\u0001\u0000\u0000\u00c7\u00c9\u0003"+
		"\u001e\u000f\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c9\u00cc\u0001"+
		"\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001"+
		"\u0000\u0000\u0000\u00cb\u001d\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001"+
		"\u0000\u0000\u0000\u00cd\u00d2\u0003 \u0010\u0000\u00ce\u00cf\u0007\u0002"+
		"\u0000\u0000\u00cf\u00d1\u0003 \u0010\u0000\u00d0\u00ce\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d4\u0001\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000"+
		"\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u001f\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d5\u00da\u0003\"\u0011\u0000"+
		"\u00d6\u00d7\u0007\u0003\u0000\u0000\u00d7\u00d9\u0003\"\u0011\u0000\u00d8"+
		"\u00d6\u0001\u0000\u0000\u0000\u00d9\u00dc\u0001\u0000\u0000\u0000\u00da"+
		"\u00d8\u0001\u0000\u0000\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db"+
		"!\u0001\u0000\u0000\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dd\u00e2"+
		"\u0003$\u0012\u0000\u00de\u00df\u0007\u0004\u0000\u0000\u00df\u00e1\u0003"+
		"$\u0012\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e1\u00e4\u0001\u0000"+
		"\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000"+
		"\u0000\u0000\u00e3#\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000"+
		"\u0000\u00e5\u00e8\u0003&\u0013\u0000\u00e6\u00e7\u0005\u0018\u0000\u0000"+
		"\u00e7\u00e9\u0003$\u0012\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e8"+
		"\u00e9\u0001\u0000\u0000\u0000\u00e9%\u0001\u0000\u0000\u0000\u00ea\u00f1"+
		"\u0003(\u0014\u0000\u00eb\u00ec\u0005\u001d\u0000\u0000\u00ec\u00ed\u0003"+
		"\u001a\r\u0000\u00ed\u00ee\u0005\u001e\u0000\u0000\u00ee\u00f0\u0001\u0000"+
		"\u0000\u0000\u00ef\u00eb\u0001\u0000\u0000\u0000\u00f0\u00f3\u0001\u0000"+
		"\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f2\'\u0001\u0000\u0000\u0000\u00f3\u00f1\u0001\u0000\u0000"+
		"\u0000\u00f4\u0100\u0005)\u0000\u0000\u00f5\u0100\u0005*\u0000\u0000\u00f6"+
		"\u00f7\u0005\u0016\u0000\u0000\u00f7\u00f8\u0003\u001a\r\u0000\u00f8\u00f9"+
		"\u0005\u0017\u0000\u0000\u00f9\u0100\u0001\u0000\u0000\u0000\u00fa\u0100"+
		"\u0003,\u0016\u0000\u00fb\u0100\u0005\u0005\u0000\u0000\u00fc\u0100\u0005"+
		"\u0006\u0000\u0000\u00fd\u0100\u0005\u0007\u0000\u0000\u00fe\u0100\u0003"+
		"*\u0015\u0000\u00ff\u00f4\u0001\u0000\u0000\u0000\u00ff\u00f5\u0001\u0000"+
		"\u0000\u0000\u00ff\u00f6\u0001\u0000\u0000\u0000\u00ff\u00fa\u0001\u0000"+
		"\u0000\u0000\u00ff\u00fb\u0001\u0000\u0000\u0000\u00ff\u00fc\u0001\u0000"+
		"\u0000\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000\u00ff\u00fe\u0001\u0000"+
		"\u0000\u0000\u0100)\u0001\u0000\u0000\u0000\u0101\u0102\u0005\u0004\u0000"+
		"\u0000\u0102\u0103\u0005*\u0000\u0000\u0103\u010c\u0005\u0016\u0000\u0000"+
		"\u0104\u0109\u0003\u001a\r\u0000\u0105\u0106\u0005\u001f\u0000\u0000\u0106"+
		"\u0108\u0003\u001a\r\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0108\u010b"+
		"\u0001\u0000\u0000\u0000\u0109\u0107\u0001\u0000\u0000\u0000\u0109\u010a"+
		"\u0001\u0000\u0000\u0000\u010a\u010d\u0001\u0000\u0000\u0000\u010b\u0109"+
		"\u0001\u0000\u0000\u0000\u010c\u0104\u0001\u0000\u0000\u0000\u010c\u010d"+
		"\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000\u0000\u0000\u010e\u010f"+
		"\u0005\u0017\u0000\u0000\u010f+\u0001\u0000\u0000\u0000\u0110\u0119\u0005"+
		"\u001d\u0000\u0000\u0111\u0116\u0003\u001a\r\u0000\u0112\u0113\u0005\u001f"+
		"\u0000\u0000\u0113\u0115\u0003\u001a\r\u0000\u0114\u0112\u0001\u0000\u0000"+
		"\u0000\u0115\u0118\u0001\u0000\u0000\u0000\u0116\u0114\u0001\u0000\u0000"+
		"\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0117\u011a\u0001\u0000\u0000"+
		"\u0000\u0118\u0116\u0001\u0000\u0000\u0000\u0119\u0111\u0001\u0000\u0000"+
		"\u0000\u0119\u011a\u0001\u0000\u0000\u0000\u011a\u011b\u0001\u0000\u0000"+
		"\u0000\u011b\u011c\u0005\u001e\u0000\u0000\u011c-\u0001\u0000\u0000\u0000"+
		"\u011d\u0124\u0005\b\u0000\u0000\u011e\u0124\u0005\t\u0000\u0000\u011f"+
		"\u0124\u0005\n\u0000\u0000\u0120\u0124\u0005\u000b\u0000\u0000\u0121\u0122"+
		"\u0005\u000b\u0000\u0000\u0122\u0124\u0003.\u0017\u0000\u0123\u011d\u0001"+
		"\u0000\u0000\u0000\u0123\u011e\u0001\u0000\u0000\u0000\u0123\u011f\u0001"+
		"\u0000\u0000\u0000\u0123\u0120\u0001\u0000\u0000\u0000\u0123\u0121\u0001"+
		"\u0000\u0000\u0000\u0124/\u0001\u0000\u0000\u0000\u001a3NTfs\u0088\u0091"+
		"\u0095\u00a0\u00a4\u00a8\u00b6\u00b9\u00be\u00ca\u00d2\u00da\u00e2\u00e8"+
		"\u00f1\u00ff\u0109\u010c\u0116\u0119\u0123";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}