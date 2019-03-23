// Generated from RegulyBiznesowe.g4 by ANTLR 4.7.2

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
public class RegulyBiznesoweParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, LITERAL_JESLI=8, 
		LITERAL_WTEDY=9, LITERAL_ORAZ=10, LITERAL_LUB=11, LITERAL_WYSWIETL_KOMUNIKAT=12, 
		LITERAL_W_PRZECIWNYM_WYPADKU=13, LITERAL_SPRAWDZ_REGULE=14, OPERATOR_POROWNANIA=15, 
		NO=16, NZ=17, INT=18, NUMERIC_VALUE=19, IDENTIFIER=20, RULECOMMENT=21, 
		NEWLINE=22, WS=23;
	public static final int
		RULE_grupa_regul = 0, RULE_regula = 1, RULE_nazwa_reguly = 2, RULE_parametry_reguly = 3, 
		RULE_tresc_reguly = 4, RULE_akcja_warunek_spelniony = 5, RULE_akcja_w_przeciwnym_wypadku = 6, 
		RULE_warunek_reguly = 7, RULE_zlozone_wyrazenie_logiczne = 8, RULE_wyrazenie_logiczne = 9, 
		RULE_warunek = 10, RULE_parametr = 11, RULE_typ = 12, RULE_nazwa = 13, 
		RULE_akcja = 14, RULE_akcja_wyswietl_komunikat = 15, RULE_akcja_sprawdz_regule = 16, 
		RULE_parametr_akcji = 17, RULE_parametr_akcji_sprawdz_regule_wywolanie_innej_reguly = 18, 
		RULE_parametry_podawane_do_innej_reguly = 19, RULE_tekst_wielowyrazowy = 20, 
		RULE_operator_logiczny = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"grupa_regul", "regula", "nazwa_reguly", "parametry_reguly", "tresc_reguly", 
			"akcja_warunek_spelniony", "akcja_w_przeciwnym_wypadku", "warunek_reguly", 
			"zlozone_wyrazenie_logiczne", "wyrazenie_logiczne", "warunek", "parametr", 
			"typ", "nazwa", "akcja", "akcja_wyswietl_komunikat", "akcja_sprawdz_regule", 
			"parametr_akcji", "parametr_akcji_sprawdz_regule_wywolanie_innej_reguly", 
			"parametry_podawane_do_innej_reguly", "tekst_wielowyrazowy", "operator_logiczny"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'n=>'", "'p=>'", "','", "'r=>'", "'\"'", null, null, 
			null, null, null, null, null, null, "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "LITERAL_JESLI", "LITERAL_WTEDY", 
			"LITERAL_ORAZ", "LITERAL_LUB", "LITERAL_WYSWIETL_KOMUNIKAT", "LITERAL_W_PRZECIWNYM_WYPADKU", 
			"LITERAL_SPRAWDZ_REGULE", "OPERATOR_POROWNANIA", "NO", "NZ", "INT", "NUMERIC_VALUE", 
			"IDENTIFIER", "RULECOMMENT", "NEWLINE", "WS"
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
	public String getGrammarFileName() { return "RegulyBiznesowe.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RegulyBiznesoweParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Grupa_regulContext extends ParserRuleContext {
		public List<RegulaContext> regula() {
			return getRuleContexts(RegulaContext.class);
		}
		public RegulaContext regula(int i) {
			return getRuleContext(RegulaContext.class,i);
		}
		public TerminalNode EOF() { return getToken(RegulyBiznesoweParser.EOF, 0); }
		public Grupa_regulContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grupa_regul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).enterGrupa_regul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).exitGrupa_regul(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegulyBiznesoweVisitor ) return ((RegulyBiznesoweVisitor<? extends T>)visitor).visitGrupa_regul(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Grupa_regulContext grupa_regul() throws RecognitionException {
		Grupa_regulContext _localctx = new Grupa_regulContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_grupa_regul);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			regula();
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(45);
				regula();
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51);
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

	public static class RegulaContext extends ParserRuleContext {
		public Nazwa_regulyContext nazwa_reguly() {
			return getRuleContext(Nazwa_regulyContext.class,0);
		}
		public Parametry_regulyContext parametry_reguly() {
			return getRuleContext(Parametry_regulyContext.class,0);
		}
		public Tresc_regulyContext tresc_reguly() {
			return getRuleContext(Tresc_regulyContext.class,0);
		}
		public RegulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).enterRegula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).exitRegula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegulyBiznesoweVisitor ) return ((RegulyBiznesoweVisitor<? extends T>)visitor).visitRegula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegulaContext regula() throws RecognitionException {
		RegulaContext _localctx = new RegulaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_regula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__0);
			setState(54);
			nazwa_reguly();
			setState(55);
			parametry_reguly();
			setState(56);
			tresc_reguly();
			setState(57);
			match(T__1);
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

	public static class Nazwa_regulyContext extends ParserRuleContext {
		public NazwaContext nazwa() {
			return getRuleContext(NazwaContext.class,0);
		}
		public Nazwa_regulyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nazwa_reguly; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).enterNazwa_reguly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).exitNazwa_reguly(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegulyBiznesoweVisitor ) return ((RegulyBiznesoweVisitor<? extends T>)visitor).visitNazwa_reguly(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nazwa_regulyContext nazwa_reguly() throws RecognitionException {
		Nazwa_regulyContext _localctx = new Nazwa_regulyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_nazwa_reguly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(T__2);
			setState(60);
			nazwa();
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

	public static class Parametry_regulyContext extends ParserRuleContext {
		public List<ParametrContext> parametr() {
			return getRuleContexts(ParametrContext.class);
		}
		public ParametrContext parametr(int i) {
			return getRuleContext(ParametrContext.class,i);
		}
		public Parametry_regulyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametry_reguly; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).enterParametry_reguly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).exitParametry_reguly(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegulyBiznesoweVisitor ) return ((RegulyBiznesoweVisitor<? extends T>)visitor).visitParametry_reguly(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parametry_regulyContext parametry_reguly() throws RecognitionException {
		Parametry_regulyContext _localctx = new Parametry_regulyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parametry_reguly);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(T__3);
			setState(63);
			parametr();
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(64);
				match(T__4);
				setState(65);
				parametr();
				}
				}
				setState(70);
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

	public static class Tresc_regulyContext extends ParserRuleContext {
		public TerminalNode LITERAL_JESLI() { return getToken(RegulyBiznesoweParser.LITERAL_JESLI, 0); }
		public TerminalNode NO() { return getToken(RegulyBiznesoweParser.NO, 0); }
		public Warunek_regulyContext warunek_reguly() {
			return getRuleContext(Warunek_regulyContext.class,0);
		}
		public TerminalNode NZ() { return getToken(RegulyBiznesoweParser.NZ, 0); }
		public TerminalNode LITERAL_WTEDY() { return getToken(RegulyBiznesoweParser.LITERAL_WTEDY, 0); }
		public Akcja_warunek_spelnionyContext akcja_warunek_spelniony() {
			return getRuleContext(Akcja_warunek_spelnionyContext.class,0);
		}
		public TerminalNode LITERAL_W_PRZECIWNYM_WYPADKU() { return getToken(RegulyBiznesoweParser.LITERAL_W_PRZECIWNYM_WYPADKU, 0); }
		public Akcja_w_przeciwnym_wypadkuContext akcja_w_przeciwnym_wypadku() {
			return getRuleContext(Akcja_w_przeciwnym_wypadkuContext.class,0);
		}
		public Tresc_regulyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tresc_reguly; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).enterTresc_reguly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).exitTresc_reguly(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegulyBiznesoweVisitor ) return ((RegulyBiznesoweVisitor<? extends T>)visitor).visitTresc_reguly(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tresc_regulyContext tresc_reguly() throws RecognitionException {
		Tresc_regulyContext _localctx = new Tresc_regulyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tresc_reguly);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__5);
			setState(72);
			match(LITERAL_JESLI);
			setState(73);
			match(NO);
			setState(74);
			warunek_reguly();
			setState(75);
			match(NZ);
			setState(76);
			match(LITERAL_WTEDY);
			setState(77);
			akcja_warunek_spelniony();
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LITERAL_W_PRZECIWNYM_WYPADKU) {
				{
				setState(78);
				match(LITERAL_W_PRZECIWNYM_WYPADKU);
				setState(79);
				akcja_w_przeciwnym_wypadku();
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

	public static class Akcja_warunek_spelnionyContext extends ParserRuleContext {
		public AkcjaContext akcja() {
			return getRuleContext(AkcjaContext.class,0);
		}
		public Akcja_warunek_spelnionyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_akcja_warunek_spelniony; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).enterAkcja_warunek_spelniony(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).exitAkcja_warunek_spelniony(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegulyBiznesoweVisitor ) return ((RegulyBiznesoweVisitor<? extends T>)visitor).visitAkcja_warunek_spelniony(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Akcja_warunek_spelnionyContext akcja_warunek_spelniony() throws RecognitionException {
		Akcja_warunek_spelnionyContext _localctx = new Akcja_warunek_spelnionyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_akcja_warunek_spelniony);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(82);
			akcja();
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

	public static class Akcja_w_przeciwnym_wypadkuContext extends ParserRuleContext {
		public AkcjaContext akcja() {
			return getRuleContext(AkcjaContext.class,0);
		}
		public Akcja_w_przeciwnym_wypadkuContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_akcja_w_przeciwnym_wypadku; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).enterAkcja_w_przeciwnym_wypadku(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).exitAkcja_w_przeciwnym_wypadku(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegulyBiznesoweVisitor ) return ((RegulyBiznesoweVisitor<? extends T>)visitor).visitAkcja_w_przeciwnym_wypadku(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Akcja_w_przeciwnym_wypadkuContext akcja_w_przeciwnym_wypadku() throws RecognitionException {
		Akcja_w_przeciwnym_wypadkuContext _localctx = new Akcja_w_przeciwnym_wypadkuContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_akcja_w_przeciwnym_wypadku);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(84);
			akcja();
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

	public static class Warunek_regulyContext extends ParserRuleContext {
		public List<Zlozone_wyrazenie_logiczneContext> zlozone_wyrazenie_logiczne() {
			return getRuleContexts(Zlozone_wyrazenie_logiczneContext.class);
		}
		public Zlozone_wyrazenie_logiczneContext zlozone_wyrazenie_logiczne(int i) {
			return getRuleContext(Zlozone_wyrazenie_logiczneContext.class,i);
		}
		public List<Operator_logicznyContext> operator_logiczny() {
			return getRuleContexts(Operator_logicznyContext.class);
		}
		public Operator_logicznyContext operator_logiczny(int i) {
			return getRuleContext(Operator_logicznyContext.class,i);
		}
		public Warunek_regulyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_warunek_reguly; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).enterWarunek_reguly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).exitWarunek_reguly(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegulyBiznesoweVisitor ) return ((RegulyBiznesoweVisitor<? extends T>)visitor).visitWarunek_reguly(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Warunek_regulyContext warunek_reguly() throws RecognitionException {
		Warunek_regulyContext _localctx = new Warunek_regulyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_warunek_reguly);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			zlozone_wyrazenie_logiczne();
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LITERAL_ORAZ || _la==LITERAL_LUB) {
				{
				{
				setState(87);
				operator_logiczny();
				setState(88);
				zlozone_wyrazenie_logiczne();
				}
				}
				setState(94);
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

	public static class Zlozone_wyrazenie_logiczneContext extends ParserRuleContext {
		public List<Wyrazenie_logiczneContext> wyrazenie_logiczne() {
			return getRuleContexts(Wyrazenie_logiczneContext.class);
		}
		public Wyrazenie_logiczneContext wyrazenie_logiczne(int i) {
			return getRuleContext(Wyrazenie_logiczneContext.class,i);
		}
		public List<WarunekContext> warunek() {
			return getRuleContexts(WarunekContext.class);
		}
		public WarunekContext warunek(int i) {
			return getRuleContext(WarunekContext.class,i);
		}
		public List<Operator_logicznyContext> operator_logiczny() {
			return getRuleContexts(Operator_logicznyContext.class);
		}
		public Operator_logicznyContext operator_logiczny(int i) {
			return getRuleContext(Operator_logicznyContext.class,i);
		}
		public Zlozone_wyrazenie_logiczneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_zlozone_wyrazenie_logiczne; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).enterZlozone_wyrazenie_logiczne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).exitZlozone_wyrazenie_logiczne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegulyBiznesoweVisitor ) return ((RegulyBiznesoweVisitor<? extends T>)visitor).visitZlozone_wyrazenie_logiczne(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Zlozone_wyrazenie_logiczneContext zlozone_wyrazenie_logiczne() throws RecognitionException {
		Zlozone_wyrazenie_logiczneContext _localctx = new Zlozone_wyrazenie_logiczneContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_zlozone_wyrazenie_logiczne);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(95);
				wyrazenie_logiczne();
				}
				break;
			case 2:
				{
				setState(96);
				warunek();
				}
				break;
			}
			setState(106);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					{
					setState(99);
					operator_logiczny();
					}
					setState(102);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						setState(100);
						wyrazenie_logiczne();
						}
						break;
					case 2:
						{
						setState(101);
						warunek();
						}
						break;
					}
					}
					} 
				}
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class Wyrazenie_logiczneContext extends ParserRuleContext {
		public List<WarunekContext> warunek() {
			return getRuleContexts(WarunekContext.class);
		}
		public WarunekContext warunek(int i) {
			return getRuleContext(WarunekContext.class,i);
		}
		public Operator_logicznyContext operator_logiczny() {
			return getRuleContext(Operator_logicznyContext.class,0);
		}
		public TerminalNode NO() { return getToken(RegulyBiznesoweParser.NO, 0); }
		public TerminalNode NZ() { return getToken(RegulyBiznesoweParser.NZ, 0); }
		public Wyrazenie_logiczneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wyrazenie_logiczne; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).enterWyrazenie_logiczne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).exitWyrazenie_logiczne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegulyBiznesoweVisitor ) return ((RegulyBiznesoweVisitor<? extends T>)visitor).visitWyrazenie_logiczne(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Wyrazenie_logiczneContext wyrazenie_logiczne() throws RecognitionException {
		Wyrazenie_logiczneContext _localctx = new Wyrazenie_logiczneContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_wyrazenie_logiczne);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(109);
				match(NO);
				}
				break;
			}
			setState(112);
			warunek();
			{
			setState(113);
			operator_logiczny();
			}
			setState(114);
			warunek();
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(115);
				match(NZ);
				}
				break;
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

	public static class WarunekContext extends ParserRuleContext {
		public List<NazwaContext> nazwa() {
			return getRuleContexts(NazwaContext.class);
		}
		public NazwaContext nazwa(int i) {
			return getRuleContext(NazwaContext.class,i);
		}
		public TerminalNode OPERATOR_POROWNANIA() { return getToken(RegulyBiznesoweParser.OPERATOR_POROWNANIA, 0); }
		public TerminalNode NUMERIC_VALUE() { return getToken(RegulyBiznesoweParser.NUMERIC_VALUE, 0); }
		public TerminalNode INT() { return getToken(RegulyBiznesoweParser.INT, 0); }
		public TerminalNode NO() { return getToken(RegulyBiznesoweParser.NO, 0); }
		public TerminalNode NZ() { return getToken(RegulyBiznesoweParser.NZ, 0); }
		public WarunekContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_warunek; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).enterWarunek(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).exitWarunek(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegulyBiznesoweVisitor ) return ((RegulyBiznesoweVisitor<? extends T>)visitor).visitWarunek(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WarunekContext warunek() throws RecognitionException {
		WarunekContext _localctx = new WarunekContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_warunek);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NO) {
				{
				setState(118);
				match(NO);
				}
			}

			setState(121);
			nazwa();
			setState(122);
			match(OPERATOR_POROWNANIA);
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMERIC_VALUE:
				{
				setState(123);
				match(NUMERIC_VALUE);
				}
				break;
			case IDENTIFIER:
				{
				setState(124);
				nazwa();
				}
				break;
			case INT:
				{
				setState(125);
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(128);
				match(NZ);
				}
				break;
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

	public static class ParametrContext extends ParserRuleContext {
		public NazwaContext nazwa() {
			return getRuleContext(NazwaContext.class,0);
		}
		public TerminalNode NO() { return getToken(RegulyBiznesoweParser.NO, 0); }
		public TypContext typ() {
			return getRuleContext(TypContext.class,0);
		}
		public TerminalNode NZ() { return getToken(RegulyBiznesoweParser.NZ, 0); }
		public ParametrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).enterParametr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).exitParametr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegulyBiznesoweVisitor ) return ((RegulyBiznesoweVisitor<? extends T>)visitor).visitParametr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametrContext parametr() throws RecognitionException {
		ParametrContext _localctx = new ParametrContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parametr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			nazwa();
			setState(132);
			match(NO);
			setState(133);
			typ();
			setState(134);
			match(NZ);
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

	public static class TypContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(RegulyBiznesoweParser.IDENTIFIER, 0); }
		public TypContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typ; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).enterTyp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).exitTyp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegulyBiznesoweVisitor ) return ((RegulyBiznesoweVisitor<? extends T>)visitor).visitTyp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypContext typ() throws RecognitionException {
		TypContext _localctx = new TypContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_typ);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(IDENTIFIER);
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

	public static class NazwaContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(RegulyBiznesoweParser.IDENTIFIER, 0); }
		public NazwaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nazwa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).enterNazwa(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).exitNazwa(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegulyBiznesoweVisitor ) return ((RegulyBiznesoweVisitor<? extends T>)visitor).visitNazwa(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NazwaContext nazwa() throws RecognitionException {
		NazwaContext _localctx = new NazwaContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_nazwa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(IDENTIFIER);
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

	public static class AkcjaContext extends ParserRuleContext {
		public Akcja_wyswietl_komunikatContext akcja_wyswietl_komunikat() {
			return getRuleContext(Akcja_wyswietl_komunikatContext.class,0);
		}
		public Akcja_sprawdz_reguleContext akcja_sprawdz_regule() {
			return getRuleContext(Akcja_sprawdz_reguleContext.class,0);
		}
		public AkcjaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_akcja; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).enterAkcja(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).exitAkcja(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegulyBiznesoweVisitor ) return ((RegulyBiznesoweVisitor<? extends T>)visitor).visitAkcja(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AkcjaContext akcja() throws RecognitionException {
		AkcjaContext _localctx = new AkcjaContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_akcja);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LITERAL_WYSWIETL_KOMUNIKAT:
				{
				setState(140);
				akcja_wyswietl_komunikat();
				}
				break;
			case LITERAL_SPRAWDZ_REGULE:
				{
				setState(141);
				akcja_sprawdz_regule();
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

	public static class Akcja_wyswietl_komunikatContext extends ParserRuleContext {
		public TerminalNode NO() { return getToken(RegulyBiznesoweParser.NO, 0); }
		public TerminalNode NZ() { return getToken(RegulyBiznesoweParser.NZ, 0); }
		public TerminalNode LITERAL_WYSWIETL_KOMUNIKAT() { return getToken(RegulyBiznesoweParser.LITERAL_WYSWIETL_KOMUNIKAT, 0); }
		public Parametr_akcjiContext parametr_akcji() {
			return getRuleContext(Parametr_akcjiContext.class,0);
		}
		public Akcja_wyswietl_komunikatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_akcja_wyswietl_komunikat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).enterAkcja_wyswietl_komunikat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).exitAkcja_wyswietl_komunikat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegulyBiznesoweVisitor ) return ((RegulyBiznesoweVisitor<? extends T>)visitor).visitAkcja_wyswietl_komunikat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Akcja_wyswietl_komunikatContext akcja_wyswietl_komunikat() throws RecognitionException {
		Akcja_wyswietl_komunikatContext _localctx = new Akcja_wyswietl_komunikatContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_akcja_wyswietl_komunikat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(144);
			match(LITERAL_WYSWIETL_KOMUNIKAT);
			}
			setState(145);
			match(NO);
			{
			setState(146);
			parametr_akcji();
			}
			setState(147);
			match(NZ);
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

	public static class Akcja_sprawdz_reguleContext extends ParserRuleContext {
		public TerminalNode NO() { return getToken(RegulyBiznesoweParser.NO, 0); }
		public TerminalNode NZ() { return getToken(RegulyBiznesoweParser.NZ, 0); }
		public TerminalNode LITERAL_SPRAWDZ_REGULE() { return getToken(RegulyBiznesoweParser.LITERAL_SPRAWDZ_REGULE, 0); }
		public Parametr_akcji_sprawdz_regule_wywolanie_innej_regulyContext parametr_akcji_sprawdz_regule_wywolanie_innej_reguly() {
			return getRuleContext(Parametr_akcji_sprawdz_regule_wywolanie_innej_regulyContext.class,0);
		}
		public Akcja_sprawdz_reguleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_akcja_sprawdz_regule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).enterAkcja_sprawdz_regule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).exitAkcja_sprawdz_regule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegulyBiznesoweVisitor ) return ((RegulyBiznesoweVisitor<? extends T>)visitor).visitAkcja_sprawdz_regule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Akcja_sprawdz_reguleContext akcja_sprawdz_regule() throws RecognitionException {
		Akcja_sprawdz_reguleContext _localctx = new Akcja_sprawdz_reguleContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_akcja_sprawdz_regule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(149);
			match(LITERAL_SPRAWDZ_REGULE);
			}
			setState(150);
			match(NO);
			{
			setState(151);
			parametr_akcji_sprawdz_regule_wywolanie_innej_reguly();
			}
			setState(152);
			match(NZ);
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

	public static class Parametr_akcjiContext extends ParserRuleContext {
		public Tekst_wielowyrazowyContext tekst_wielowyrazowy() {
			return getRuleContext(Tekst_wielowyrazowyContext.class,0);
		}
		public TerminalNode NUMERIC_VALUE() { return getToken(RegulyBiznesoweParser.NUMERIC_VALUE, 0); }
		public TerminalNode INT() { return getToken(RegulyBiznesoweParser.INT, 0); }
		public Parametr_akcjiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametr_akcji; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).enterParametr_akcji(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).exitParametr_akcji(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegulyBiznesoweVisitor ) return ((RegulyBiznesoweVisitor<? extends T>)visitor).visitParametr_akcji(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parametr_akcjiContext parametr_akcji() throws RecognitionException {
		Parametr_akcjiContext _localctx = new Parametr_akcjiContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_parametr_akcji);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(154);
				match(T__6);
				}
			}

			setState(160);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(157);
				tekst_wielowyrazowy();
				}
				break;
			case NUMERIC_VALUE:
				{
				setState(158);
				match(NUMERIC_VALUE);
				}
				break;
			case INT:
				{
				setState(159);
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(162);
				match(T__6);
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

	public static class Parametr_akcji_sprawdz_regule_wywolanie_innej_regulyContext extends ParserRuleContext {
		public NazwaContext nazwa() {
			return getRuleContext(NazwaContext.class,0);
		}
		public TerminalNode NO() { return getToken(RegulyBiznesoweParser.NO, 0); }
		public Parametry_podawane_do_innej_regulyContext parametry_podawane_do_innej_reguly() {
			return getRuleContext(Parametry_podawane_do_innej_regulyContext.class,0);
		}
		public TerminalNode NZ() { return getToken(RegulyBiznesoweParser.NZ, 0); }
		public Parametr_akcji_sprawdz_regule_wywolanie_innej_regulyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametr_akcji_sprawdz_regule_wywolanie_innej_reguly; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).enterParametr_akcji_sprawdz_regule_wywolanie_innej_reguly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).exitParametr_akcji_sprawdz_regule_wywolanie_innej_reguly(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegulyBiznesoweVisitor ) return ((RegulyBiznesoweVisitor<? extends T>)visitor).visitParametr_akcji_sprawdz_regule_wywolanie_innej_reguly(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parametr_akcji_sprawdz_regule_wywolanie_innej_regulyContext parametr_akcji_sprawdz_regule_wywolanie_innej_reguly() throws RecognitionException {
		Parametr_akcji_sprawdz_regule_wywolanie_innej_regulyContext _localctx = new Parametr_akcji_sprawdz_regule_wywolanie_innej_regulyContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_parametr_akcji_sprawdz_regule_wywolanie_innej_reguly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			nazwa();
			setState(166);
			match(NO);
			setState(167);
			parametry_podawane_do_innej_reguly();
			setState(168);
			match(NZ);
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

	public static class Parametry_podawane_do_innej_regulyContext extends ParserRuleContext {
		public List<NazwaContext> nazwa() {
			return getRuleContexts(NazwaContext.class);
		}
		public NazwaContext nazwa(int i) {
			return getRuleContext(NazwaContext.class,i);
		}
		public Parametry_podawane_do_innej_regulyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametry_podawane_do_innej_reguly; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).enterParametry_podawane_do_innej_reguly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).exitParametry_podawane_do_innej_reguly(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegulyBiznesoweVisitor ) return ((RegulyBiznesoweVisitor<? extends T>)visitor).visitParametry_podawane_do_innej_reguly(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parametry_podawane_do_innej_regulyContext parametry_podawane_do_innej_reguly() throws RecognitionException {
		Parametry_podawane_do_innej_regulyContext _localctx = new Parametry_podawane_do_innej_regulyContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_parametry_podawane_do_innej_reguly);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			nazwa();
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				{
				setState(171);
				match(T__4);
				}
				setState(172);
				nazwa();
				}
				}
				setState(177);
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

	public static class Tekst_wielowyrazowyContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(RegulyBiznesoweParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(RegulyBiznesoweParser.IDENTIFIER, i);
		}
		public Tekst_wielowyrazowyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tekst_wielowyrazowy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).enterTekst_wielowyrazowy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).exitTekst_wielowyrazowy(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegulyBiznesoweVisitor ) return ((RegulyBiznesoweVisitor<? extends T>)visitor).visitTekst_wielowyrazowy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tekst_wielowyrazowyContext tekst_wielowyrazowy() throws RecognitionException {
		Tekst_wielowyrazowyContext _localctx = new Tekst_wielowyrazowyContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_tekst_wielowyrazowy);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(IDENTIFIER);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(179);
				match(IDENTIFIER);
				}
				}
				setState(184);
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

	public static class Operator_logicznyContext extends ParserRuleContext {
		public TerminalNode LITERAL_ORAZ() { return getToken(RegulyBiznesoweParser.LITERAL_ORAZ, 0); }
		public TerminalNode LITERAL_LUB() { return getToken(RegulyBiznesoweParser.LITERAL_LUB, 0); }
		public Operator_logicznyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_logiczny; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).enterOperator_logiczny(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegulyBiznesoweListener ) ((RegulyBiznesoweListener)listener).exitOperator_logiczny(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegulyBiznesoweVisitor ) return ((RegulyBiznesoweVisitor<? extends T>)visitor).visitOperator_logiczny(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operator_logicznyContext operator_logiczny() throws RecognitionException {
		Operator_logicznyContext _localctx = new Operator_logicznyContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_operator_logiczny);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			_la = _input.LA(1);
			if ( !(_la==LITERAL_ORAZ || _la==LITERAL_LUB) ) {
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31\u00be\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\7\2\61\n\2"+
		"\f\2\16\2\64\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\7\5E\n\5\f\5\16\5H\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5"+
		"\6S\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\7\t]\n\t\f\t\16\t`\13\t\3\n\3"+
		"\n\5\nd\n\n\3\n\3\n\3\n\5\ni\n\n\7\nk\n\n\f\n\16\nn\13\n\3\13\5\13q\n"+
		"\13\3\13\3\13\3\13\3\13\5\13w\n\13\3\f\5\fz\n\f\3\f\3\f\3\f\3\f\3\f\5"+
		"\f\u0081\n\f\3\f\5\f\u0084\n\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\5\20\u0091\n\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\5\23\u009e\n\23\3\23\3\23\3\23\5\23\u00a3\n\23\3\23\5\23\u00a6"+
		"\n\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\7\25\u00b0\n\25\f\25\16"+
		"\25\u00b3\13\25\3\26\3\26\7\26\u00b7\n\26\f\26\16\26\u00ba\13\26\3\27"+
		"\3\27\3\27\2\2\30\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\3\3"+
		"\2\f\r\2\u00bb\2.\3\2\2\2\4\67\3\2\2\2\6=\3\2\2\2\b@\3\2\2\2\nI\3\2\2"+
		"\2\fT\3\2\2\2\16V\3\2\2\2\20X\3\2\2\2\22c\3\2\2\2\24p\3\2\2\2\26y\3\2"+
		"\2\2\30\u0085\3\2\2\2\32\u008a\3\2\2\2\34\u008c\3\2\2\2\36\u0090\3\2\2"+
		"\2 \u0092\3\2\2\2\"\u0097\3\2\2\2$\u009d\3\2\2\2&\u00a7\3\2\2\2(\u00ac"+
		"\3\2\2\2*\u00b4\3\2\2\2,\u00bb\3\2\2\2.\62\5\4\3\2/\61\5\4\3\2\60/\3\2"+
		"\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64\62\3\2"+
		"\2\2\65\66\7\2\2\3\66\3\3\2\2\2\678\7\3\2\289\5\6\4\29:\5\b\5\2:;\5\n"+
		"\6\2;<\7\4\2\2<\5\3\2\2\2=>\7\5\2\2>?\5\34\17\2?\7\3\2\2\2@A\7\6\2\2A"+
		"F\5\30\r\2BC\7\7\2\2CE\5\30\r\2DB\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2"+
		"\2G\t\3\2\2\2HF\3\2\2\2IJ\7\b\2\2JK\7\n\2\2KL\7\22\2\2LM\5\20\t\2MN\7"+
		"\23\2\2NO\7\13\2\2OR\5\f\7\2PQ\7\17\2\2QS\5\16\b\2RP\3\2\2\2RS\3\2\2\2"+
		"S\13\3\2\2\2TU\5\36\20\2U\r\3\2\2\2VW\5\36\20\2W\17\3\2\2\2X^\5\22\n\2"+
		"YZ\5,\27\2Z[\5\22\n\2[]\3\2\2\2\\Y\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2"+
		"\2\2_\21\3\2\2\2`^\3\2\2\2ad\5\24\13\2bd\5\26\f\2ca\3\2\2\2cb\3\2\2\2"+
		"dl\3\2\2\2eh\5,\27\2fi\5\24\13\2gi\5\26\f\2hf\3\2\2\2hg\3\2\2\2ik\3\2"+
		"\2\2je\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\23\3\2\2\2nl\3\2\2\2oq\7"+
		"\22\2\2po\3\2\2\2pq\3\2\2\2qr\3\2\2\2rs\5\26\f\2st\5,\27\2tv\5\26\f\2"+
		"uw\7\23\2\2vu\3\2\2\2vw\3\2\2\2w\25\3\2\2\2xz\7\22\2\2yx\3\2\2\2yz\3\2"+
		"\2\2z{\3\2\2\2{|\5\34\17\2|\u0080\7\21\2\2}\u0081\7\25\2\2~\u0081\5\34"+
		"\17\2\177\u0081\7\24\2\2\u0080}\3\2\2\2\u0080~\3\2\2\2\u0080\177\3\2\2"+
		"\2\u0081\u0083\3\2\2\2\u0082\u0084\7\23\2\2\u0083\u0082\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\27\3\2\2\2\u0085\u0086\5\34\17\2\u0086\u0087\7\22"+
		"\2\2\u0087\u0088\5\32\16\2\u0088\u0089\7\23\2\2\u0089\31\3\2\2\2\u008a"+
		"\u008b\7\26\2\2\u008b\33\3\2\2\2\u008c\u008d\7\26\2\2\u008d\35\3\2\2\2"+
		"\u008e\u0091\5 \21\2\u008f\u0091\5\"\22\2\u0090\u008e\3\2\2\2\u0090\u008f"+
		"\3\2\2\2\u0091\37\3\2\2\2\u0092\u0093\7\16\2\2\u0093\u0094\7\22\2\2\u0094"+
		"\u0095\5$\23\2\u0095\u0096\7\23\2\2\u0096!\3\2\2\2\u0097\u0098\7\20\2"+
		"\2\u0098\u0099\7\22\2\2\u0099\u009a\5&\24\2\u009a\u009b\7\23\2\2\u009b"+
		"#\3\2\2\2\u009c\u009e\7\t\2\2\u009d\u009c\3\2\2\2\u009d\u009e\3\2\2\2"+
		"\u009e\u00a2\3\2\2\2\u009f\u00a3\5*\26\2\u00a0\u00a3\7\25\2\2\u00a1\u00a3"+
		"\7\24\2\2\u00a2\u009f\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2\2\2"+
		"\u00a3\u00a5\3\2\2\2\u00a4\u00a6\7\t\2\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6"+
		"\3\2\2\2\u00a6%\3\2\2\2\u00a7\u00a8\5\34\17\2\u00a8\u00a9\7\22\2\2\u00a9"+
		"\u00aa\5(\25\2\u00aa\u00ab\7\23\2\2\u00ab\'\3\2\2\2\u00ac\u00b1\5\34\17"+
		"\2\u00ad\u00ae\7\7\2\2\u00ae\u00b0\5\34\17\2\u00af\u00ad\3\2\2\2\u00b0"+
		"\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2)\3\2\2\2"+
		"\u00b3\u00b1\3\2\2\2\u00b4\u00b8\7\26\2\2\u00b5\u00b7\7\26\2\2\u00b6\u00b5"+
		"\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"+\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc\t\2\2\2\u00bc-\3\2\2\2\24\62"+
		"FR^chlpvy\u0080\u0083\u0090\u009d\u00a2\u00a5\u00b1\u00b8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}