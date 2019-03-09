// Generated from io\github\calc\Calc.g4 by ANTLR 4.7.2
package io.github.calc;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalcLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, MUL=2, DIV=3, ADD=4, SUB=5, LP=6, RP=7, ID=8, NUMBER=9, NEWLINE=10, 
		INT=11, FLOAT=12, STRING=13, LINE_COMMENT=14, BLOCK_COMMENT=15, WS=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "MUL", "DIV", "ADD", "SUB", "LP", "RP", "ID", "NUMBER", "Letter", 
			"Digit", "LetterOrDigit", "DIGIT", "NEWLINE", "INT", "FLOAT", "STRING", 
			"ESC", "LINE_COMMENT", "BLOCK_COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'*'", "'/'", "'+'", "'-'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "MUL", "DIV", "ADD", "SUB", "LP", "RP", "ID", "NUMBER", "NEWLINE", 
			"INT", "FLOAT", "STRING", "LINE_COMMENT", "BLOCK_COMMENT", "WS"
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


	public CalcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calc.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22\u00b2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\7\t>\n\t\f\t\16\tA\13\t\3\n\6"+
		"\nD\n\n\r\n\16\nE\3\n\6\nI\n\n\r\n\16\nJ\3\n\3\n\7\nO\n\n\f\n\16\nR\13"+
		"\n\3\n\3\n\6\nV\n\n\r\n\16\nW\5\nZ\n\n\3\13\3\13\3\f\3\f\3\r\3\r\5\rb"+
		"\n\r\3\16\3\16\3\17\5\17g\n\17\3\17\3\17\3\20\6\20l\n\20\r\20\16\20m\3"+
		"\21\6\21q\n\21\r\21\16\21r\3\21\3\21\7\21w\n\21\f\21\16\21z\13\21\3\21"+
		"\3\21\6\21~\n\21\r\21\16\21\177\5\21\u0082\n\21\3\22\3\22\3\22\7\22\u0087"+
		"\n\22\f\22\16\22\u008a\13\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3"+
		"\24\7\24\u0095\n\24\f\24\16\24\u0098\13\24\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\7\25\u00a2\n\25\f\25\16\25\u00a5\13\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\26\6\26\u00ad\n\26\r\26\16\26\u00ae\3\26\3\26\5\u0088\u0096"+
		"\u00a3\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\2\27\2\31\2\33"+
		"\2\35\f\37\r!\16#\17%\2\'\20)\21+\22\3\2\6\5\2C\\aac|\3\2\62;\b\2$$^^"+
		"ddppttvv\5\2\13\f\17\17\"\"\2\u00bf\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2\'\3\2\2\2\2"+
		")\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5/\3\2\2\2\7\61\3\2\2\2\t\63\3\2\2\2\13"+
		"\65\3\2\2\2\r\67\3\2\2\2\179\3\2\2\2\21;\3\2\2\2\23Y\3\2\2\2\25[\3\2\2"+
		"\2\27]\3\2\2\2\31a\3\2\2\2\33c\3\2\2\2\35f\3\2\2\2\37k\3\2\2\2!\u0081"+
		"\3\2\2\2#\u0083\3\2\2\2%\u008d\3\2\2\2\'\u0090\3\2\2\2)\u009d\3\2\2\2"+
		"+\u00ac\3\2\2\2-.\7?\2\2.\4\3\2\2\2/\60\7,\2\2\60\6\3\2\2\2\61\62\7\61"+
		"\2\2\62\b\3\2\2\2\63\64\7-\2\2\64\n\3\2\2\2\65\66\7/\2\2\66\f\3\2\2\2"+
		"\678\7*\2\28\16\3\2\2\29:\7+\2\2:\20\3\2\2\2;?\5\25\13\2<>\5\31\r\2=<"+
		"\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\22\3\2\2\2A?\3\2\2\2BD\5\33\16"+
		"\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2FZ\3\2\2\2GI\5\33\16\2HG\3\2"+
		"\2\2IJ\3\2\2\2JH\3\2\2\2JK\3\2\2\2KL\3\2\2\2LP\7\60\2\2MO\5\33\16\2NM"+
		"\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QZ\3\2\2\2RP\3\2\2\2SU\7\60\2\2"+
		"TV\5\33\16\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YC\3\2\2"+
		"\2YH\3\2\2\2YS\3\2\2\2Z\24\3\2\2\2[\\\t\2\2\2\\\26\3\2\2\2]^\t\3\2\2^"+
		"\30\3\2\2\2_b\5\25\13\2`b\5\27\f\2a_\3\2\2\2a`\3\2\2\2b\32\3\2\2\2cd\4"+
		"\62;\2d\34\3\2\2\2eg\7\17\2\2fe\3\2\2\2fg\3\2\2\2gh\3\2\2\2hi\7\f\2\2"+
		"i\36\3\2\2\2jl\5\33\16\2kj\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2n \3\2"+
		"\2\2oq\5\33\16\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2st\3\2\2\2tx\7"+
		"\60\2\2uw\5\33\16\2vu\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\u0082\3\2"+
		"\2\2zx\3\2\2\2{}\7\60\2\2|~\5\33\16\2}|\3\2\2\2~\177\3\2\2\2\177}\3\2"+
		"\2\2\177\u0080\3\2\2\2\u0080\u0082\3\2\2\2\u0081p\3\2\2\2\u0081{\3\2\2"+
		"\2\u0082\"\3\2\2\2\u0083\u0088\7$\2\2\u0084\u0087\5%\23\2\u0085\u0087"+
		"\13\2\2\2\u0086\u0084\3\2\2\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2"+
		"\u0088\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u0088"+
		"\3\2\2\2\u008b\u008c\7$\2\2\u008c$\3\2\2\2\u008d\u008e\7^\2\2\u008e\u008f"+
		"\t\4\2\2\u008f&\3\2\2\2\u0090\u0091\7\61\2\2\u0091\u0092\7\61\2\2\u0092"+
		"\u0096\3\2\2\2\u0093\u0095\13\2\2\2\u0094\u0093\3\2\2\2\u0095\u0098\3"+
		"\2\2\2\u0096\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u0099\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0099\u009a\7\f\2\2\u009a\u009b\3\2\2\2\u009b\u009c\b\24"+
		"\2\2\u009c(\3\2\2\2\u009d\u009e\7\61\2\2\u009e\u009f\7,\2\2\u009f\u00a3"+
		"\3\2\2\2\u00a0\u00a2\13\2\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2\2\2"+
		"\u00a3\u00a4\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a3"+
		"\3\2\2\2\u00a6\u00a7\7,\2\2\u00a7\u00a8\7\61\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00aa\b\25\2\2\u00aa*\3\2\2\2\u00ab\u00ad\t\5\2\2\u00ac\u00ab\3\2\2\2"+
		"\u00ad\u00ae\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0"+
		"\3\2\2\2\u00b0\u00b1\b\26\2\2\u00b1,\3\2\2\2\25\2?EJPWYafmrx\177\u0081"+
		"\u0086\u0088\u0096\u00a3\u00ae\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}