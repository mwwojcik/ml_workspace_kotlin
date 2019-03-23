// Generated from RegulyBiznesowe.g4 by ANTLR 4.7.2

package reguly.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RegulyBiznesoweLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "LITERAL_JESLI", 
			"LITERAL_WTEDY", "LITERAL_ORAZ", "LITERAL_LUB", "LITERAL_WYSWIETL_KOMUNIKAT", 
			"LITERAL_W_PRZECIWNYM_WYPADKU", "LITERAL_SPRAWDZ_REGULE", "OPERATOR_POROWNANIA", 
			"NO", "NZ", "INT", "NUMERIC_VALUE", "IDENTIFIER", "RULECOMMENT", "NEWLINE", 
			"WS", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", 
			"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
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


	public RegulyBiznesoweLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RegulyBiznesowe.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u0132\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00c3"+
		"\n\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\7\23\u00cc\n\23\f\23\16\23\u00cf"+
		"\13\23\5\23\u00d1\n\23\3\24\5\24\u00d4\n\24\3\24\6\24\u00d7\n\24\r\24"+
		"\16\24\u00d8\3\24\3\24\6\24\u00dd\n\24\r\24\16\24\u00de\5\24\u00e1\n\24"+
		"\3\25\3\25\7\25\u00e5\n\25\f\25\16\25\u00e8\13\25\3\26\3\26\7\26\u00ec"+
		"\n\26\f\26\16\26\u00ef\13\26\3\27\5\27\u00f2\n\27\3\27\3\27\3\27\3\27"+
		"\3\30\6\30\u00f9\n\30\r\30\16\30\u00fa\3\30\3\30\3\31\3\31\3\32\3\32\3"+
		"\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3"+
		"#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3."+
		"\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\2\2\63\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\2\63\2\65\2\67\29\2;\2=\2?\2A\2C\2E\2G\2I\2K\2M\2"+
		"O\2Q\2S\2U\2W\2Y\2[\2]\2_\2a\2c\2\3\2#\4\2>>@@\3\2\63;\3\2\62;\5\2C\\"+
		"aac|\6\2\62;C\\aac|\4\2\f\f\17\17\5\2\13\f\16\17\"\"\4\2CCcc\4\2DDdd\4"+
		"\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMm"+
		"m\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2"+
		"VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u0124\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3e\3\2"+
		"\2\2\5g\3\2\2\2\7i\3\2\2\2\tm\3\2\2\2\13q\3\2\2\2\rs\3\2\2\2\17w\3\2\2"+
		"\2\21y\3\2\2\2\23\177\3\2\2\2\25\u0085\3\2\2\2\27\u008a\3\2\2\2\31\u008e"+
		"\3\2\2\2\33\u0097\3\2\2\2\35\u00ac\3\2\2\2\37\u00c2\3\2\2\2!\u00c4\3\2"+
		"\2\2#\u00c6\3\2\2\2%\u00d0\3\2\2\2\'\u00d3\3\2\2\2)\u00e2\3\2\2\2+\u00e9"+
		"\3\2\2\2-\u00f1\3\2\2\2/\u00f8\3\2\2\2\61\u00fe\3\2\2\2\63\u0100\3\2\2"+
		"\2\65\u0102\3\2\2\2\67\u0104\3\2\2\29\u0106\3\2\2\2;\u0108\3\2\2\2=\u010a"+
		"\3\2\2\2?\u010c\3\2\2\2A\u010e\3\2\2\2C\u0110\3\2\2\2E\u0112\3\2\2\2G"+
		"\u0114\3\2\2\2I\u0116\3\2\2\2K\u0118\3\2\2\2M\u011a\3\2\2\2O\u011c\3\2"+
		"\2\2Q\u011e\3\2\2\2S\u0120\3\2\2\2U\u0122\3\2\2\2W\u0124\3\2\2\2Y\u0126"+
		"\3\2\2\2[\u0128\3\2\2\2]\u012a\3\2\2\2_\u012c\3\2\2\2a\u012e\3\2\2\2c"+
		"\u0130\3\2\2\2ef\7}\2\2f\4\3\2\2\2gh\7\177\2\2h\6\3\2\2\2ij\7p\2\2jk\7"+
		"?\2\2kl\7@\2\2l\b\3\2\2\2mn\7r\2\2no\7?\2\2op\7@\2\2p\n\3\2\2\2qr\7.\2"+
		"\2r\f\3\2\2\2st\7t\2\2tu\7?\2\2uv\7@\2\2v\16\3\2\2\2wx\7$\2\2x\20\3\2"+
		"\2\2yz\5C\"\2z{\59\35\2{|\5U+\2|}\5G$\2}~\5A!\2~\22\3\2\2\2\177\u0080"+
		"\5]/\2\u0080\u0081\5W,\2\u0081\u0082\59\35\2\u0082\u0083\5\67\34\2\u0083"+
		"\u0084\5a\61\2\u0084\24\3\2\2\2\u0085\u0086\5M\'\2\u0086\u0087\5S*\2\u0087"+
		"\u0088\5\61\31\2\u0088\u0089\5c\62\2\u0089\26\3\2\2\2\u008a\u008b\5G$"+
		"\2\u008b\u008c\5Y-\2\u008c\u008d\5\63\32\2\u008d\30\3\2\2\2\u008e\u008f"+
		"\5]/\2\u008f\u0090\5a\61\2\u0090\u0091\5U+\2\u0091\u0092\5]/\2\u0092\u0093"+
		"\5A!\2\u0093\u0094\59\35\2\u0094\u0095\5W,\2\u0095\u0096\5G$\2\u0096\32"+
		"\3\2\2\2\u0097\u0098\5]/\2\u0098\u0099\7a\2\2\u0099\u009a\5O(\2\u009a"+
		"\u009b\5S*\2\u009b\u009c\5c\62\2\u009c\u009d\59\35\2\u009d\u009e\5\65"+
		"\33\2\u009e\u009f\5A!\2\u009f\u00a0\5]/\2\u00a0\u00a1\5K&\2\u00a1\u00a2"+
		"\5a\61\2\u00a2\u00a3\5I%\2\u00a3\u00a4\7a\2\2\u00a4\u00a5\5]/\2\u00a5"+
		"\u00a6\5a\61\2\u00a6\u00a7\5O(\2\u00a7\u00a8\5\61\31\2\u00a8\u00a9\5\67"+
		"\34\2\u00a9\u00aa\5E#\2\u00aa\u00ab\5Y-\2\u00ab\34\3\2\2\2\u00ac\u00ad"+
		"\5U+\2\u00ad\u00ae\5O(\2\u00ae\u00af\5S*\2\u00af\u00b0\5\61\31\2\u00b0"+
		"\u00b1\5]/\2\u00b1\u00b2\5\67\34\2\u00b2\u00b3\5c\62\2\u00b3\u00b4\7a"+
		"\2\2\u00b4\u00b5\5S*\2\u00b5\u00b6\59\35\2\u00b6\u00b7\5=\37\2\u00b7\u00b8"+
		"\5Y-\2\u00b8\u00b9\5G$\2\u00b9\u00ba\59\35\2\u00ba\36\3\2\2\2\u00bb\u00bc"+
		"\7?\2\2\u00bc\u00c3\7?\2\2\u00bd\u00c3\t\2\2\2\u00be\u00bf\7@\2\2\u00bf"+
		"\u00c3\7?\2\2\u00c0\u00c1\7>\2\2\u00c1\u00c3\7?\2\2\u00c2\u00bb\3\2\2"+
		"\2\u00c2\u00bd\3\2\2\2\u00c2\u00be\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3 "+
		"\3\2\2\2\u00c4\u00c5\7*\2\2\u00c5\"\3\2\2\2\u00c6\u00c7\7+\2\2\u00c7$"+
		"\3\2\2\2\u00c8\u00d1\7\62\2\2\u00c9\u00cd\t\3\2\2\u00ca\u00cc\t\4\2\2"+
		"\u00cb\u00ca\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce"+
		"\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00c8\3\2\2\2\u00d0"+
		"\u00c9\3\2\2\2\u00d1&\3\2\2\2\u00d2\u00d4\7/\2\2\u00d3\u00d2\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00d7\t\4\2\2\u00d6\u00d5\3\2"+
		"\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"\u00e0\3\2\2\2\u00da\u00dc\7\60\2\2\u00db\u00dd\t\4\2\2\u00dc\u00db\3"+
		"\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\u00e1\3\2\2\2\u00e0\u00da\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1(\3\2\2\2"+
		"\u00e2\u00e6\t\5\2\2\u00e3\u00e5\t\6\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e8"+
		"\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7*\3\2\2\2\u00e8"+
		"\u00e6\3\2\2\2\u00e9\u00ed\7%\2\2\u00ea\u00ec\n\7\2\2\u00eb\u00ea\3\2"+
		"\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee"+
		",\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f2\7\17\2\2\u00f1\u00f0\3\2\2\2"+
		"\u00f1\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\7\f\2\2\u00f4\u00f5"+
		"\3\2\2\2\u00f5\u00f6\b\27\2\2\u00f6.\3\2\2\2\u00f7\u00f9\t\b\2\2\u00f8"+
		"\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2"+
		"\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\b\30\2\2\u00fd\60\3\2\2\2\u00fe\u00ff"+
		"\t\t\2\2\u00ff\62\3\2\2\2\u0100\u0101\t\n\2\2\u0101\64\3\2\2\2\u0102\u0103"+
		"\t\13\2\2\u0103\66\3\2\2\2\u0104\u0105\t\f\2\2\u01058\3\2\2\2\u0106\u0107"+
		"\t\r\2\2\u0107:\3\2\2\2\u0108\u0109\t\16\2\2\u0109<\3\2\2\2\u010a\u010b"+
		"\t\17\2\2\u010b>\3\2\2\2\u010c\u010d\t\20\2\2\u010d@\3\2\2\2\u010e\u010f"+
		"\t\21\2\2\u010fB\3\2\2\2\u0110\u0111\t\22\2\2\u0111D\3\2\2\2\u0112\u0113"+
		"\t\23\2\2\u0113F\3\2\2\2\u0114\u0115\t\24\2\2\u0115H\3\2\2\2\u0116\u0117"+
		"\t\25\2\2\u0117J\3\2\2\2\u0118\u0119\t\26\2\2\u0119L\3\2\2\2\u011a\u011b"+
		"\t\27\2\2\u011bN\3\2\2\2\u011c\u011d\t\30\2\2\u011dP\3\2\2\2\u011e\u011f"+
		"\t\31\2\2\u011fR\3\2\2\2\u0120\u0121\t\32\2\2\u0121T\3\2\2\2\u0122\u0123"+
		"\t\33\2\2\u0123V\3\2\2\2\u0124\u0125\t\34\2\2\u0125X\3\2\2\2\u0126\u0127"+
		"\t\35\2\2\u0127Z\3\2\2\2\u0128\u0129\t\36\2\2\u0129\\\3\2\2\2\u012a\u012b"+
		"\t\37\2\2\u012b^\3\2\2\2\u012c\u012d\t \2\2\u012d`\3\2\2\2\u012e\u012f"+
		"\t!\2\2\u012fb\3\2\2\2\u0130\u0131\t\"\2\2\u0131d\3\2\2\2\16\2\u00c2\u00cd"+
		"\u00d0\u00d3\u00d8\u00de\u00e0\u00e6\u00ed\u00f1\u00fa\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}