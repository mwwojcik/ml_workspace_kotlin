// Generated from RuleSet.g4 by ANTLR 4.7.2

package reguly.antlr;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RuleSetParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, INT=42, NUMERIC_VALUE=43, IDENTIFIER=44, 
		RULECOMMENT=45, NEWLINE=46, WS=47;
	public static final int
		RULE_rule_set = 0, RULE_single_rule = 1, RULE_logical_expr = 2, RULE_specification_expr = 3, 
		RULE_left_arithmetic_expr = 4, RULE_right_arithmetic_expr = 5, RULE_arithmetic_expr = 6, 
		RULE_numeric_expr = 7, RULE_value_expr = 8, RULE_total_expr = 9, RULE_jsonpath_expr = 10, 
		RULE_jsonpath_dotnotation_expr = 11, RULE_dotnotation_expr = 12, RULE_identifierWithQualifier = 13, 
		RULE_query_expr = 14, RULE_string_comparison_value = 15, RULE_string_array = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"rule_set", "single_rule", "logical_expr", "specification_expr", "left_arithmetic_expr", 
			"right_arithmetic_expr", "arithmetic_expr", "numeric_expr", "value_expr", 
			"total_expr", "jsonpath_expr", "jsonpath_dotnotation_expr", "dotnotation_expr", 
			"identifierWithQualifier", "query_expr", "string_comparison_value", "string_array"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'and'", "'or'", "'not'", "'SUM('", "') greater than ('", "')'", 
			"') greater than '", "'('", "' greater than '", "' greater than ('", 
			"') less than ('", "') less than '", "' less than ('", "' less than '", 
			"'equals'", "'contains'", "'is true'", "'is false'", "'includes one'", 
			"'*'", "'/'", "'+'", "'-'", "'$.'", "'.'", "'[]'", "'[*]'", "'['", "']'", 
			"'[?('", "')]'", "'&&'", "'||'", "'@.'", "'>'", "'<'", "'@.length-'", 
			"'=='", "'==''", "'''", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "INT", "NUMERIC_VALUE", "IDENTIFIER", 
			"RULECOMMENT", "NEWLINE", "WS"
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
	public String getGrammarFileName() { return "RuleSet.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RuleSetParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Rule_setContext extends ParserRuleContext {
		public List<Single_ruleContext> single_rule() {
			return getRuleContexts(Single_ruleContext.class);
		}
		public Single_ruleContext single_rule(int i) {
			return getRuleContext(Single_ruleContext.class,i);
		}
		public TerminalNode EOF() { return getToken(RuleSetParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(RuleSetParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RuleSetParser.NEWLINE, i);
		}
		public Rule_setContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterRule_set(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitRule_set(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitRule_set(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rule_setContext rule_set() throws RecognitionException {
		Rule_setContext _localctx = new Rule_setContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_rule_set);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			single_rule();
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(35);
				match(NEWLINE);
				setState(36);
				single_rule();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42);
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

	public static class Single_ruleContext extends ParserRuleContext {
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public TerminalNode RULECOMMENT() { return getToken(RuleSetParser.RULECOMMENT, 0); }
		public Single_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterSingle_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitSingle_rule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitSingle_rule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_ruleContext single_rule() throws RecognitionException {
		Single_ruleContext _localctx = new Single_ruleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_single_rule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			logical_expr(0);
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RULECOMMENT) {
				{
				setState(45);
				match(RULECOMMENT);
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

	public static class Logical_exprContext extends ParserRuleContext {
		public Logical_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_expr; }
	 
		public Logical_exprContext() { }
		public void copyFrom(Logical_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogicalExpressionAndContext extends Logical_exprContext {
		public List<Logical_exprContext> logical_expr() {
			return getRuleContexts(Logical_exprContext.class);
		}
		public Logical_exprContext logical_expr(int i) {
			return getRuleContext(Logical_exprContext.class,i);
		}
		public LogicalExpressionAndContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterLogicalExpressionAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitLogicalExpressionAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitLogicalExpressionAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalExpressionNotContext extends Logical_exprContext {
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public LogicalExpressionNotContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterLogicalExpressionNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitLogicalExpressionNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitLogicalExpressionNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalExpressionOrContext extends Logical_exprContext {
		public List<Logical_exprContext> logical_expr() {
			return getRuleContexts(Logical_exprContext.class);
		}
		public Logical_exprContext logical_expr(int i) {
			return getRuleContext(Logical_exprContext.class,i);
		}
		public LogicalExpressionOrContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterLogicalExpressionOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitLogicalExpressionOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitLogicalExpressionOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SpecificationExpressionContext extends Logical_exprContext {
		public Specification_exprContext specification_expr() {
			return getRuleContext(Specification_exprContext.class,0);
		}
		public SpecificationExpressionContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterSpecificationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitSpecificationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitSpecificationExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_exprContext logical_expr() throws RecognitionException {
		return logical_expr(0);
	}

	private Logical_exprContext logical_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Logical_exprContext _localctx = new Logical_exprContext(_ctx, _parentState);
		Logical_exprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_logical_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				_localctx = new LogicalExpressionNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(49);
				match(T__2);
				setState(50);
				logical_expr(2);
				}
				break;
			case T__3:
			case T__7:
			case T__23:
			case INT:
			case NUMERIC_VALUE:
			case IDENTIFIER:
				{
				_localctx = new SpecificationExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(51);
				specification_expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(62);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(60);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalExpressionAndContext(new Logical_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(54);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(55);
						match(T__0);
						setState(56);
						logical_expr(5);
						}
						break;
					case 2:
						{
						_localctx = new LogicalExpressionOrContext(new Logical_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
						setState(57);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(58);
						match(T__1);
						setState(59);
						logical_expr(4);
						}
						break;
					}
					} 
				}
				setState(64);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Specification_exprContext extends ParserRuleContext {
		public Specification_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specification_expr; }
	 
		public Specification_exprContext() { }
		public void copyFrom(Specification_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringEqualsComparisonSpecificationExpressionContext extends Specification_exprContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public String_comparison_valueContext string_comparison_value() {
			return getRuleContext(String_comparison_valueContext.class,0);
		}
		public StringEqualsComparisonSpecificationExpressionContext(Specification_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterStringEqualsComparisonSpecificationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitStringEqualsComparisonSpecificationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitStringEqualsComparisonSpecificationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanIsFalseComparisonSpecificationExpressionContext extends Specification_exprContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public BooleanIsFalseComparisonSpecificationExpressionContext(Specification_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterBooleanIsFalseComparisonSpecificationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitBooleanIsFalseComparisonSpecificationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitBooleanIsFalseComparisonSpecificationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TotalledNumericLessThanComparisonSpecificationExpressionContext extends Specification_exprContext {
		public Jsonpath_exprContext jsonpath_expr() {
			return getRuleContext(Jsonpath_exprContext.class,0);
		}
		public Right_arithmetic_exprContext right_arithmetic_expr() {
			return getRuleContext(Right_arithmetic_exprContext.class,0);
		}
		public Numeric_exprContext numeric_expr() {
			return getRuleContext(Numeric_exprContext.class,0);
		}
		public TotalledNumericLessThanComparisonSpecificationExpressionContext(Specification_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterTotalledNumericLessThanComparisonSpecificationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitTotalledNumericLessThanComparisonSpecificationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitTotalledNumericLessThanComparisonSpecificationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TotalledNumericGreaterThanComparisonSpecificationExpressionContext extends Specification_exprContext {
		public Jsonpath_exprContext jsonpath_expr() {
			return getRuleContext(Jsonpath_exprContext.class,0);
		}
		public Right_arithmetic_exprContext right_arithmetic_expr() {
			return getRuleContext(Right_arithmetic_exprContext.class,0);
		}
		public Numeric_exprContext numeric_expr() {
			return getRuleContext(Numeric_exprContext.class,0);
		}
		public TotalledNumericGreaterThanComparisonSpecificationExpressionContext(Specification_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterTotalledNumericGreaterThanComparisonSpecificationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitTotalledNumericGreaterThanComparisonSpecificationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitTotalledNumericGreaterThanComparisonSpecificationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumericLessThanComparisonSpecificationExpressionContext extends Specification_exprContext {
		public Left_arithmetic_exprContext left_arithmetic_expr() {
			return getRuleContext(Left_arithmetic_exprContext.class,0);
		}
		public Right_arithmetic_exprContext right_arithmetic_expr() {
			return getRuleContext(Right_arithmetic_exprContext.class,0);
		}
		public List<Numeric_exprContext> numeric_expr() {
			return getRuleContexts(Numeric_exprContext.class);
		}
		public Numeric_exprContext numeric_expr(int i) {
			return getRuleContext(Numeric_exprContext.class,i);
		}
		public NumericLessThanComparisonSpecificationExpressionContext(Specification_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterNumericLessThanComparisonSpecificationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitNumericLessThanComparisonSpecificationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitNumericLessThanComparisonSpecificationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayIncludesOneComparisonSpecificationExpressionContext extends Specification_exprContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public String_arrayContext string_array() {
			return getRuleContext(String_arrayContext.class,0);
		}
		public ArrayIncludesOneComparisonSpecificationExpressionContext(Specification_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterArrayIncludesOneComparisonSpecificationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitArrayIncludesOneComparisonSpecificationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitArrayIncludesOneComparisonSpecificationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanIsTrueComparisonSpecificationExpressionContext extends Specification_exprContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public BooleanIsTrueComparisonSpecificationExpressionContext(Specification_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterBooleanIsTrueComparisonSpecificationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitBooleanIsTrueComparisonSpecificationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitBooleanIsTrueComparisonSpecificationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContainsComparisonSpecificationExpressionContext extends Specification_exprContext {
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public String_comparison_valueContext string_comparison_value() {
			return getRuleContext(String_comparison_valueContext.class,0);
		}
		public StringContainsComparisonSpecificationExpressionContext(Specification_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterStringContainsComparisonSpecificationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitStringContainsComparisonSpecificationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitStringContainsComparisonSpecificationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumericGreaterThanComparisonSpecificationExpressionContext extends Specification_exprContext {
		public Left_arithmetic_exprContext left_arithmetic_expr() {
			return getRuleContext(Left_arithmetic_exprContext.class,0);
		}
		public Right_arithmetic_exprContext right_arithmetic_expr() {
			return getRuleContext(Right_arithmetic_exprContext.class,0);
		}
		public List<Numeric_exprContext> numeric_expr() {
			return getRuleContexts(Numeric_exprContext.class);
		}
		public Numeric_exprContext numeric_expr(int i) {
			return getRuleContext(Numeric_exprContext.class,i);
		}
		public NumericGreaterThanComparisonSpecificationExpressionContext(Specification_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterNumericGreaterThanComparisonSpecificationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitNumericGreaterThanComparisonSpecificationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitNumericGreaterThanComparisonSpecificationExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Specification_exprContext specification_expr() throws RecognitionException {
		Specification_exprContext _localctx = new Specification_exprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_specification_expr);
		try {
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new TotalledNumericGreaterThanComparisonSpecificationExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(T__3);
				setState(66);
				jsonpath_expr();
				setState(67);
				match(T__4);
				setState(68);
				right_arithmetic_expr();
				setState(69);
				match(T__5);
				}
				break;
			case 2:
				_localctx = new TotalledNumericGreaterThanComparisonSpecificationExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				match(T__3);
				setState(72);
				jsonpath_expr();
				setState(73);
				match(T__6);
				setState(74);
				numeric_expr();
				}
				break;
			case 3:
				_localctx = new NumericGreaterThanComparisonSpecificationExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				match(T__7);
				setState(77);
				left_arithmetic_expr();
				setState(78);
				match(T__4);
				setState(79);
				right_arithmetic_expr();
				setState(80);
				match(T__5);
				}
				break;
			case 4:
				_localctx = new NumericGreaterThanComparisonSpecificationExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(82);
				match(T__7);
				setState(83);
				left_arithmetic_expr();
				setState(84);
				match(T__6);
				setState(85);
				numeric_expr();
				}
				break;
			case 5:
				_localctx = new NumericGreaterThanComparisonSpecificationExpressionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(87);
				numeric_expr();
				setState(88);
				match(T__8);
				setState(89);
				numeric_expr();
				}
				break;
			case 6:
				_localctx = new NumericGreaterThanComparisonSpecificationExpressionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(91);
				numeric_expr();
				setState(92);
				match(T__9);
				setState(93);
				right_arithmetic_expr();
				setState(94);
				match(T__5);
				}
				break;
			case 7:
				_localctx = new NumericGreaterThanComparisonSpecificationExpressionContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(96);
				numeric_expr();
				setState(97);
				match(T__8);
				setState(98);
				numeric_expr();
				}
				break;
			case 8:
				_localctx = new TotalledNumericLessThanComparisonSpecificationExpressionContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(100);
				match(T__3);
				setState(101);
				jsonpath_expr();
				setState(102);
				match(T__10);
				setState(103);
				right_arithmetic_expr();
				setState(104);
				match(T__5);
				}
				break;
			case 9:
				_localctx = new TotalledNumericLessThanComparisonSpecificationExpressionContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(106);
				match(T__3);
				setState(107);
				jsonpath_expr();
				setState(108);
				match(T__11);
				setState(109);
				numeric_expr();
				}
				break;
			case 10:
				_localctx = new NumericLessThanComparisonSpecificationExpressionContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(111);
				match(T__7);
				setState(112);
				left_arithmetic_expr();
				setState(113);
				match(T__10);
				setState(114);
				right_arithmetic_expr();
				setState(115);
				match(T__5);
				}
				break;
			case 11:
				_localctx = new NumericLessThanComparisonSpecificationExpressionContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(117);
				match(T__7);
				setState(118);
				left_arithmetic_expr();
				setState(119);
				match(T__11);
				setState(120);
				numeric_expr();
				}
				break;
			case 12:
				_localctx = new NumericLessThanComparisonSpecificationExpressionContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(122);
				numeric_expr();
				setState(123);
				match(T__12);
				setState(124);
				right_arithmetic_expr();
				setState(125);
				match(T__5);
				}
				break;
			case 13:
				_localctx = new NumericLessThanComparisonSpecificationExpressionContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(127);
				numeric_expr();
				setState(128);
				match(T__13);
				setState(129);
				numeric_expr();
				}
				break;
			case 14:
				_localctx = new StringEqualsComparisonSpecificationExpressionContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(131);
				value_expr();
				setState(132);
				match(T__14);
				setState(133);
				string_comparison_value();
				}
				break;
			case 15:
				_localctx = new StringContainsComparisonSpecificationExpressionContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(135);
				value_expr();
				setState(136);
				match(T__15);
				setState(137);
				string_comparison_value();
				}
				break;
			case 16:
				_localctx = new BooleanIsTrueComparisonSpecificationExpressionContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(139);
				value_expr();
				setState(140);
				match(T__16);
				}
				break;
			case 17:
				_localctx = new BooleanIsFalseComparisonSpecificationExpressionContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(142);
				value_expr();
				setState(143);
				match(T__17);
				}
				break;
			case 18:
				_localctx = new ArrayIncludesOneComparisonSpecificationExpressionContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(145);
				value_expr();
				setState(146);
				match(T__18);
				setState(147);
				string_array();
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

	public static class Left_arithmetic_exprContext extends ParserRuleContext {
		public Arithmetic_exprContext arithmetic_expr() {
			return getRuleContext(Arithmetic_exprContext.class,0);
		}
		public Left_arithmetic_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_left_arithmetic_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterLeft_arithmetic_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitLeft_arithmetic_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitLeft_arithmetic_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Left_arithmetic_exprContext left_arithmetic_expr() throws RecognitionException {
		Left_arithmetic_exprContext _localctx = new Left_arithmetic_exprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_left_arithmetic_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			arithmetic_expr(0);
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

	public static class Right_arithmetic_exprContext extends ParserRuleContext {
		public Arithmetic_exprContext arithmetic_expr() {
			return getRuleContext(Arithmetic_exprContext.class,0);
		}
		public Right_arithmetic_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_right_arithmetic_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterRight_arithmetic_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitRight_arithmetic_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitRight_arithmetic_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Right_arithmetic_exprContext right_arithmetic_expr() throws RecognitionException {
		Right_arithmetic_exprContext _localctx = new Right_arithmetic_exprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_right_arithmetic_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			arithmetic_expr(0);
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

	public static class Arithmetic_exprContext extends ParserRuleContext {
		public Arithmetic_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_expr; }
	 
		public Arithmetic_exprContext() { }
		public void copyFrom(Arithmetic_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArithmeticExpressionMultContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public ArithmeticExpressionMultContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterArithmeticExpressionMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitArithmeticExpressionMult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitArithmeticExpressionMult(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticExpressionMinusContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public ArithmeticExpressionMinusContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterArithmeticExpressionMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitArithmeticExpressionMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitArithmeticExpressionMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticExpressionNumericEntityContext extends Arithmetic_exprContext {
		public Numeric_exprContext numeric_expr() {
			return getRuleContext(Numeric_exprContext.class,0);
		}
		public ArithmeticExpressionNumericEntityContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterArithmeticExpressionNumericEntity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitArithmeticExpressionNumericEntity(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitArithmeticExpressionNumericEntity(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticExpressionDivContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public ArithmeticExpressionDivContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterArithmeticExpressionDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitArithmeticExpressionDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitArithmeticExpressionDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticExpressionPlusContext extends Arithmetic_exprContext {
		public List<Arithmetic_exprContext> arithmetic_expr() {
			return getRuleContexts(Arithmetic_exprContext.class);
		}
		public Arithmetic_exprContext arithmetic_expr(int i) {
			return getRuleContext(Arithmetic_exprContext.class,i);
		}
		public ArithmeticExpressionPlusContext(Arithmetic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterArithmeticExpressionPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitArithmeticExpressionPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitArithmeticExpressionPlus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arithmetic_exprContext arithmetic_expr() throws RecognitionException {
		return arithmetic_expr(0);
	}

	private Arithmetic_exprContext arithmetic_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Arithmetic_exprContext _localctx = new Arithmetic_exprContext(_ctx, _parentState);
		Arithmetic_exprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_arithmetic_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ArithmeticExpressionNumericEntityContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(156);
			numeric_expr();
			}
			_ctx.stop = _input.LT(-1);
			setState(172);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(170);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticExpressionMultContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(158);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(159);
						match(T__19);
						setState(160);
						arithmetic_expr(6);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticExpressionDivContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(161);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(162);
						match(T__20);
						setState(163);
						arithmetic_expr(5);
						}
						break;
					case 3:
						{
						_localctx = new ArithmeticExpressionPlusContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(164);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(165);
						match(T__21);
						setState(166);
						arithmetic_expr(4);
						}
						break;
					case 4:
						{
						_localctx = new ArithmeticExpressionMinusContext(new Arithmetic_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
						setState(167);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(168);
						match(T__22);
						setState(169);
						arithmetic_expr(3);
						}
						break;
					}
					} 
				}
				setState(174);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Numeric_exprContext extends ParserRuleContext {
		public Numeric_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_expr; }
	 
		public Numeric_exprContext() { }
		public void copyFrom(Numeric_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NumericConstantContext extends Numeric_exprContext {
		public TerminalNode NUMERIC_VALUE() { return getToken(RuleSetParser.NUMERIC_VALUE, 0); }
		public TerminalNode INT() { return getToken(RuleSetParser.INT, 0); }
		public NumericConstantContext(Numeric_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterNumericConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitNumericConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitNumericConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TotalledJsonPathExpressionContext extends Numeric_exprContext {
		public Total_exprContext total_expr() {
			return getRuleContext(Total_exprContext.class,0);
		}
		public TotalledJsonPathExpressionContext(Numeric_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterTotalledJsonPathExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitTotalledJsonPathExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitTotalledJsonPathExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JsonPathExpressionContext extends Numeric_exprContext {
		public Jsonpath_exprContext jsonpath_expr() {
			return getRuleContext(Jsonpath_exprContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(RuleSetParser.IDENTIFIER, 0); }
		public JsonPathExpressionContext(Numeric_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterJsonPathExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitJsonPathExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitJsonPathExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numeric_exprContext numeric_expr() throws RecognitionException {
		Numeric_exprContext _localctx = new Numeric_exprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_numeric_expr);
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				_localctx = new TotalledJsonPathExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				total_expr();
				}
				break;
			case T__23:
				_localctx = new JsonPathExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				jsonpath_expr();
				}
				break;
			case IDENTIFIER:
				_localctx = new JsonPathExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(177);
				match(IDENTIFIER);
				}
				break;
			case NUMERIC_VALUE:
				_localctx = new NumericConstantContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(178);
				match(NUMERIC_VALUE);
				}
				break;
			case INT:
				_localctx = new NumericConstantContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(179);
				match(INT);
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

	public static class Value_exprContext extends ParserRuleContext {
		public Jsonpath_exprContext jsonpath_expr() {
			return getRuleContext(Jsonpath_exprContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(RuleSetParser.IDENTIFIER, 0); }
		public Value_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterValue_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitValue_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitValue_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Value_exprContext value_expr() throws RecognitionException {
		Value_exprContext _localctx = new Value_exprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_value_expr);
		try {
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				jsonpath_expr();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				match(IDENTIFIER);
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

	public static class Total_exprContext extends ParserRuleContext {
		public Jsonpath_exprContext jsonpath_expr() {
			return getRuleContext(Jsonpath_exprContext.class,0);
		}
		public Total_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_total_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterTotal_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitTotal_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitTotal_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Total_exprContext total_expr() throws RecognitionException {
		Total_exprContext _localctx = new Total_exprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_total_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(T__3);
			setState(187);
			jsonpath_expr();
			setState(188);
			match(T__5);
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

	public static class Jsonpath_exprContext extends ParserRuleContext {
		public Jsonpath_dotnotation_exprContext jsonpath_dotnotation_expr() {
			return getRuleContext(Jsonpath_dotnotation_exprContext.class,0);
		}
		public Jsonpath_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jsonpath_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterJsonpath_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitJsonpath_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitJsonpath_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Jsonpath_exprContext jsonpath_expr() throws RecognitionException {
		Jsonpath_exprContext _localctx = new Jsonpath_exprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_jsonpath_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			jsonpath_dotnotation_expr();
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

	public static class Jsonpath_dotnotation_exprContext extends ParserRuleContext {
		public List<Dotnotation_exprContext> dotnotation_expr() {
			return getRuleContexts(Dotnotation_exprContext.class);
		}
		public Dotnotation_exprContext dotnotation_expr(int i) {
			return getRuleContext(Dotnotation_exprContext.class,i);
		}
		public Jsonpath_dotnotation_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jsonpath_dotnotation_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterJsonpath_dotnotation_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitJsonpath_dotnotation_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitJsonpath_dotnotation_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Jsonpath_dotnotation_exprContext jsonpath_dotnotation_expr() throws RecognitionException {
		Jsonpath_dotnotation_exprContext _localctx = new Jsonpath_dotnotation_exprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_jsonpath_dotnotation_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(T__23);
			setState(193);
			dotnotation_expr();
			setState(198);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(194);
					match(T__24);
					setState(195);
					dotnotation_expr();
					}
					} 
				}
				setState(200);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	public static class Dotnotation_exprContext extends ParserRuleContext {
		public IdentifierWithQualifierContext identifierWithQualifier() {
			return getRuleContext(IdentifierWithQualifierContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(RuleSetParser.IDENTIFIER, 0); }
		public Dotnotation_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotnotation_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterDotnotation_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitDotnotation_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitDotnotation_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dotnotation_exprContext dotnotation_expr() throws RecognitionException {
		Dotnotation_exprContext _localctx = new Dotnotation_exprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_dotnotation_expr);
		try {
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				identifierWithQualifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				match(IDENTIFIER);
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

	public static class IdentifierWithQualifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(RuleSetParser.IDENTIFIER, 0); }
		public TerminalNode INT() { return getToken(RuleSetParser.INT, 0); }
		public Query_exprContext query_expr() {
			return getRuleContext(Query_exprContext.class,0);
		}
		public IdentifierWithQualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierWithQualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterIdentifierWithQualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitIdentifierWithQualifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitIdentifierWithQualifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierWithQualifierContext identifierWithQualifier() throws RecognitionException {
		IdentifierWithQualifierContext _localctx = new IdentifierWithQualifierContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_identifierWithQualifier);
		try {
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				match(IDENTIFIER);
				setState(206);
				match(T__25);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				match(IDENTIFIER);
				setState(208);
				match(T__26);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(209);
				match(IDENTIFIER);
				setState(210);
				match(T__27);
				setState(211);
				match(INT);
				setState(212);
				match(T__28);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(213);
				match(IDENTIFIER);
				setState(214);
				match(T__29);
				setState(215);
				query_expr(0);
				setState(216);
				match(T__30);
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

	public static class Query_exprContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(RuleSetParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(RuleSetParser.IDENTIFIER, i);
		}
		public TerminalNode INT() { return getToken(RuleSetParser.INT, 0); }
		public List<Query_exprContext> query_expr() {
			return getRuleContexts(Query_exprContext.class);
		}
		public Query_exprContext query_expr(int i) {
			return getRuleContext(Query_exprContext.class,i);
		}
		public Query_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterQuery_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitQuery_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitQuery_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Query_exprContext query_expr() throws RecognitionException {
		return query_expr(0);
	}

	private Query_exprContext query_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Query_exprContext _localctx = new Query_exprContext(_ctx, _parentState);
		Query_exprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_query_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(221);
				match(T__33);
				setState(222);
				match(IDENTIFIER);
				}
				break;
			case 2:
				{
				setState(223);
				match(T__33);
				setState(224);
				match(IDENTIFIER);
				setState(225);
				match(T__34);
				setState(226);
				match(INT);
				}
				break;
			case 3:
				{
				setState(227);
				match(T__33);
				setState(228);
				match(IDENTIFIER);
				setState(229);
				match(T__35);
				setState(230);
				match(INT);
				}
				break;
			case 4:
				{
				setState(231);
				match(T__36);
				setState(232);
				match(INT);
				}
				break;
			case 5:
				{
				setState(233);
				match(T__33);
				setState(234);
				match(IDENTIFIER);
				setState(235);
				match(T__37);
				setState(236);
				match(INT);
				}
				break;
			case 6:
				{
				setState(237);
				match(T__33);
				setState(238);
				match(IDENTIFIER);
				setState(239);
				match(T__38);
				setState(240);
				match(IDENTIFIER);
				setState(241);
				match(T__39);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(260);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(258);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new Query_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_query_expr);
						setState(244);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(247); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(245);
								match(T__31);
								setState(246);
								query_expr(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(249); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 2:
						{
						_localctx = new Query_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_query_expr);
						setState(251);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(254); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(252);
								match(T__32);
								setState(253);
								query_expr(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(256); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					}
					} 
				}
				setState(262);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class String_comparison_valueContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(RuleSetParser.INT, 0); }
		public TerminalNode NUMERIC_VALUE() { return getToken(RuleSetParser.NUMERIC_VALUE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(RuleSetParser.IDENTIFIER, 0); }
		public String_comparison_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_comparison_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterString_comparison_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitString_comparison_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitString_comparison_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final String_comparison_valueContext string_comparison_value() throws RecognitionException {
		String_comparison_valueContext _localctx = new String_comparison_valueContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_string_comparison_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << NUMERIC_VALUE) | (1L << IDENTIFIER))) != 0)) ) {
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

	public static class String_arrayContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(RuleSetParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(RuleSetParser.IDENTIFIER, i);
		}
		public String_arrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).enterString_array(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleSetListener ) ((RuleSetListener)listener).exitString_array(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleSetVisitor ) return ((RuleSetVisitor<? extends T>)visitor).visitString_array(this);
			else return visitor.visitChildren(this);
		}
	}

	public final String_arrayContext string_array() throws RecognitionException {
		String_arrayContext _localctx = new String_arrayContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_string_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(T__7);
			setState(266);
			match(IDENTIFIER);
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__40) {
				{
				{
				setState(267);
				match(T__40);
				setState(268);
				match(IDENTIFIER);
				}
				}
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(274);
			match(T__5);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return logical_expr_sempred((Logical_exprContext)_localctx, predIndex);
		case 6:
			return arithmetic_expr_sempred((Arithmetic_exprContext)_localctx, predIndex);
		case 14:
			return query_expr_sempred((Query_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logical_expr_sempred(Logical_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean arithmetic_expr_sempred(Arithmetic_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean query_expr_sempred(Query_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u0117\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\7\2(\n\2\f\2\16\2+\13\2\3\2\3\2\3\3\3\3\5\3\61\n\3\3\4\3"+
		"\4\3\4\3\4\5\4\67\n\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4?\n\4\f\4\16\4B\13\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0098\n\5"+
		"\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\7\b\u00ad\n\b\f\b\16\b\u00b0\13\b\3\t\3\t\3\t\3\t\3\t\5\t\u00b7"+
		"\n\t\3\n\3\n\5\n\u00bb\n\n\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\7\r\u00c7\n\r\f\r\16\r\u00ca\13\r\3\16\3\16\5\16\u00ce\n\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00dd\n\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00f5\n\20\3\20\3\20\3\20"+
		"\6\20\u00fa\n\20\r\20\16\20\u00fb\3\20\3\20\3\20\6\20\u0101\n\20\r\20"+
		"\16\20\u0102\7\20\u0105\n\20\f\20\16\20\u0108\13\20\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\7\22\u0110\n\22\f\22\16\22\u0113\13\22\3\22\3\22\3\22\2\5\6"+
		"\16\36\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\3\3\2,.\2\u0133"+
		"\2$\3\2\2\2\4.\3\2\2\2\6\66\3\2\2\2\b\u0097\3\2\2\2\n\u0099\3\2\2\2\f"+
		"\u009b\3\2\2\2\16\u009d\3\2\2\2\20\u00b6\3\2\2\2\22\u00ba\3\2\2\2\24\u00bc"+
		"\3\2\2\2\26\u00c0\3\2\2\2\30\u00c2\3\2\2\2\32\u00cd\3\2\2\2\34\u00dc\3"+
		"\2\2\2\36\u00f4\3\2\2\2 \u0109\3\2\2\2\"\u010b\3\2\2\2$)\5\4\3\2%&\7\60"+
		"\2\2&(\5\4\3\2\'%\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3"+
		"\2\2\2,-\7\2\2\3-\3\3\2\2\2.\60\5\6\4\2/\61\7/\2\2\60/\3\2\2\2\60\61\3"+
		"\2\2\2\61\5\3\2\2\2\62\63\b\4\1\2\63\64\7\5\2\2\64\67\5\6\4\4\65\67\5"+
		"\b\5\2\66\62\3\2\2\2\66\65\3\2\2\2\67@\3\2\2\289\f\6\2\29:\7\3\2\2:?\5"+
		"\6\4\7;<\f\5\2\2<=\7\4\2\2=?\5\6\4\6>8\3\2\2\2>;\3\2\2\2?B\3\2\2\2@>\3"+
		"\2\2\2@A\3\2\2\2A\7\3\2\2\2B@\3\2\2\2CD\7\6\2\2DE\5\26\f\2EF\7\7\2\2F"+
		"G\5\f\7\2GH\7\b\2\2H\u0098\3\2\2\2IJ\7\6\2\2JK\5\26\f\2KL\7\t\2\2LM\5"+
		"\20\t\2M\u0098\3\2\2\2NO\7\n\2\2OP\5\n\6\2PQ\7\7\2\2QR\5\f\7\2RS\7\b\2"+
		"\2S\u0098\3\2\2\2TU\7\n\2\2UV\5\n\6\2VW\7\t\2\2WX\5\20\t\2X\u0098\3\2"+
		"\2\2YZ\5\20\t\2Z[\7\13\2\2[\\\5\20\t\2\\\u0098\3\2\2\2]^\5\20\t\2^_\7"+
		"\f\2\2_`\5\f\7\2`a\7\b\2\2a\u0098\3\2\2\2bc\5\20\t\2cd\7\13\2\2de\5\20"+
		"\t\2e\u0098\3\2\2\2fg\7\6\2\2gh\5\26\f\2hi\7\r\2\2ij\5\f\7\2jk\7\b\2\2"+
		"k\u0098\3\2\2\2lm\7\6\2\2mn\5\26\f\2no\7\16\2\2op\5\20\t\2p\u0098\3\2"+
		"\2\2qr\7\n\2\2rs\5\n\6\2st\7\r\2\2tu\5\f\7\2uv\7\b\2\2v\u0098\3\2\2\2"+
		"wx\7\n\2\2xy\5\n\6\2yz\7\16\2\2z{\5\20\t\2{\u0098\3\2\2\2|}\5\20\t\2}"+
		"~\7\17\2\2~\177\5\f\7\2\177\u0080\7\b\2\2\u0080\u0098\3\2\2\2\u0081\u0082"+
		"\5\20\t\2\u0082\u0083\7\20\2\2\u0083\u0084\5\20\t\2\u0084\u0098\3\2\2"+
		"\2\u0085\u0086\5\22\n\2\u0086\u0087\7\21\2\2\u0087\u0088\5 \21\2\u0088"+
		"\u0098\3\2\2\2\u0089\u008a\5\22\n\2\u008a\u008b\7\22\2\2\u008b\u008c\5"+
		" \21\2\u008c\u0098\3\2\2\2\u008d\u008e\5\22\n\2\u008e\u008f\7\23\2\2\u008f"+
		"\u0098\3\2\2\2\u0090\u0091\5\22\n\2\u0091\u0092\7\24\2\2\u0092\u0098\3"+
		"\2\2\2\u0093\u0094\5\22\n\2\u0094\u0095\7\25\2\2\u0095\u0096\5\"\22\2"+
		"\u0096\u0098\3\2\2\2\u0097C\3\2\2\2\u0097I\3\2\2\2\u0097N\3\2\2\2\u0097"+
		"T\3\2\2\2\u0097Y\3\2\2\2\u0097]\3\2\2\2\u0097b\3\2\2\2\u0097f\3\2\2\2"+
		"\u0097l\3\2\2\2\u0097q\3\2\2\2\u0097w\3\2\2\2\u0097|\3\2\2\2\u0097\u0081"+
		"\3\2\2\2\u0097\u0085\3\2\2\2\u0097\u0089\3\2\2\2\u0097\u008d\3\2\2\2\u0097"+
		"\u0090\3\2\2\2\u0097\u0093\3\2\2\2\u0098\t\3\2\2\2\u0099\u009a\5\16\b"+
		"\2\u009a\13\3\2\2\2\u009b\u009c\5\16\b\2\u009c\r\3\2\2\2\u009d\u009e\b"+
		"\b\1\2\u009e\u009f\5\20\t\2\u009f\u00ae\3\2\2\2\u00a0\u00a1\f\7\2\2\u00a1"+
		"\u00a2\7\26\2\2\u00a2\u00ad\5\16\b\b\u00a3\u00a4\f\6\2\2\u00a4\u00a5\7"+
		"\27\2\2\u00a5\u00ad\5\16\b\7\u00a6\u00a7\f\5\2\2\u00a7\u00a8\7\30\2\2"+
		"\u00a8\u00ad\5\16\b\6\u00a9\u00aa\f\4\2\2\u00aa\u00ab\7\31\2\2\u00ab\u00ad"+
		"\5\16\b\5\u00ac\u00a0\3\2\2\2\u00ac\u00a3\3\2\2\2\u00ac\u00a6\3\2\2\2"+
		"\u00ac\u00a9\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af"+
		"\3\2\2\2\u00af\17\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b7\5\24\13\2\u00b2"+
		"\u00b7\5\26\f\2\u00b3\u00b7\7.\2\2\u00b4\u00b7\7-\2\2\u00b5\u00b7\7,\2"+
		"\2\u00b6\u00b1\3\2\2\2\u00b6\u00b2\3\2\2\2\u00b6\u00b3\3\2\2\2\u00b6\u00b4"+
		"\3\2\2\2\u00b6\u00b5\3\2\2\2\u00b7\21\3\2\2\2\u00b8\u00bb\5\26\f\2\u00b9"+
		"\u00bb\7.\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00b9\3\2\2\2\u00bb\23\3\2\2\2"+
		"\u00bc\u00bd\7\6\2\2\u00bd\u00be\5\26\f\2\u00be\u00bf\7\b\2\2\u00bf\25"+
		"\3\2\2\2\u00c0\u00c1\5\30\r\2\u00c1\27\3\2\2\2\u00c2\u00c3\7\32\2\2\u00c3"+
		"\u00c8\5\32\16\2\u00c4\u00c5\7\33\2\2\u00c5\u00c7\5\32\16\2\u00c6\u00c4"+
		"\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\31\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00ce\5\34\17\2\u00cc\u00ce\7.\2"+
		"\2\u00cd\u00cb\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce\33\3\2\2\2\u00cf\u00d0"+
		"\7.\2\2\u00d0\u00dd\7\34\2\2\u00d1\u00d2\7.\2\2\u00d2\u00dd\7\35\2\2\u00d3"+
		"\u00d4\7.\2\2\u00d4\u00d5\7\36\2\2\u00d5\u00d6\7,\2\2\u00d6\u00dd\7\37"+
		"\2\2\u00d7\u00d8\7.\2\2\u00d8\u00d9\7 \2\2\u00d9\u00da\5\36\20\2\u00da"+
		"\u00db\7!\2\2\u00db\u00dd\3\2\2\2\u00dc\u00cf\3\2\2\2\u00dc\u00d1\3\2"+
		"\2\2\u00dc\u00d3\3\2\2\2\u00dc\u00d7\3\2\2\2\u00dd\35\3\2\2\2\u00de\u00df"+
		"\b\20\1\2\u00df\u00e0\7$\2\2\u00e0\u00f5\7.\2\2\u00e1\u00e2\7$\2\2\u00e2"+
		"\u00e3\7.\2\2\u00e3\u00e4\7%\2\2\u00e4\u00f5\7,\2\2\u00e5\u00e6\7$\2\2"+
		"\u00e6\u00e7\7.\2\2\u00e7\u00e8\7&\2\2\u00e8\u00f5\7,\2\2\u00e9\u00ea"+
		"\7\'\2\2\u00ea\u00f5\7,\2\2\u00eb\u00ec\7$\2\2\u00ec\u00ed\7.\2\2\u00ed"+
		"\u00ee\7(\2\2\u00ee\u00f5\7,\2\2\u00ef\u00f0\7$\2\2\u00f0\u00f1\7.\2\2"+
		"\u00f1\u00f2\7)\2\2\u00f2\u00f3\7.\2\2\u00f3\u00f5\7*\2\2\u00f4\u00de"+
		"\3\2\2\2\u00f4\u00e1\3\2\2\2\u00f4\u00e5\3\2\2\2\u00f4\u00e9\3\2\2\2\u00f4"+
		"\u00eb\3\2\2\2\u00f4\u00ef\3\2\2\2\u00f5\u0106\3\2\2\2\u00f6\u00f9\f\n"+
		"\2\2\u00f7\u00f8\7\"\2\2\u00f8\u00fa\5\36\20\2\u00f9\u00f7\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u0105\3\2"+
		"\2\2\u00fd\u0100\f\t\2\2\u00fe\u00ff\7#\2\2\u00ff\u0101\5\36\20\2\u0100"+
		"\u00fe\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2"+
		"\2\2\u0103\u0105\3\2\2\2\u0104\u00f6\3\2\2\2\u0104\u00fd\3\2\2\2\u0105"+
		"\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\37\3\2\2"+
		"\2\u0108\u0106\3\2\2\2\u0109\u010a\t\2\2\2\u010a!\3\2\2\2\u010b\u010c"+
		"\7\n\2\2\u010c\u0111\7.\2\2\u010d\u010e\7+\2\2\u010e\u0110\7.\2\2\u010f"+
		"\u010d\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2"+
		"\2\2\u0112\u0114\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0115\7\b\2\2\u0115"+
		"#\3\2\2\2\25)\60\66>@\u0097\u00ac\u00ae\u00b6\u00ba\u00c8\u00cd\u00dc"+
		"\u00f4\u00fb\u0102\u0104\u0106\u0111";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}