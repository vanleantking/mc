// Generated from src/main/mc/parser/MC.g4 by ANTLR 4.6

	package mc.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MCLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BLOCK_COMMENT=1, LINE_COMMENT=2, INTLIT=3, FLOAT_LITERAL=4, BOOLEAN_LITERAL=5, 
		STRINGLIT=6, BOOLEAN=7, BREAK=8, CONTINUE=9, ELSE=10, FOR=11, FLOAT=12, 
		IF=13, INT=14, RETURN=15, VOID=16, DO=17, WHILE=18, TRUE=19, FALSE=20, 
		STRING=21, ADD=22, SUB=23, MUL=24, FDIV=25, NOT=26, MOD=27, OR=28, AND=29, 
		NEQU=30, EQU=31, LT=32, GT=33, LE=34, GE=35, ASSIGN=36, LB=37, RB=38, 
		LP=39, RP=40, LSB=41, RSB=42, SEMI=43, COLON=44, COMMA=45, LF=46, WS=47, 
		IDENTIFIERS=48, ERROR_CHAR=49, UNCLOSE_STRING=50, ILLEGAL_ESCAPE=51;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"BLOCK_COMMENT", "LINE_COMMENT", "INTLIT", "FLOAT_LITERAL", "BOOLEAN_LITERAL", 
		"STRINGLIT", "BOOLEAN", "BREAK", "CONTINUE", "ELSE", "FOR", "FLOAT", "IF", 
		"INT", "RETURN", "VOID", "DO", "WHILE", "TRUE", "FALSE", "STRING", "ADD", 
		"SUB", "MUL", "FDIV", "NOT", "MOD", "OR", "AND", "NEQU", "EQU", "LT", 
		"GT", "LE", "GE", "ASSIGN", "LB", "RB", "LP", "RP", "LSB", "RSB", "SEMI", 
		"COLON", "COMMA", "LF", "WS", "IDENTIFIERS", "LOWERCASE", "UPPERCASE", 
		"DIGIT", "UNDERSCORE", "Decimal", "Exponent", "ERROR_CHAR", "UNCLOSE_STRING", 
		"ILLEGAL_ESCAPE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, "'boolean'", "'break'", "'continue'", 
		"'else'", "'for'", "'float'", "'if'", "'int'", "'return'", "'void'", "'do'", 
		"'while'", "'true'", "'false'", "'string'", "'+'", "'-'", "'*'", "'/'", 
		"'!'", "'%'", "'||'", "'&&'", "'!='", "'=='", "'<'", "'>'", "'<='", "'>='", 
		"'='", "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "':'", "','", 
		"'\\n'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BLOCK_COMMENT", "LINE_COMMENT", "INTLIT", "FLOAT_LITERAL", "BOOLEAN_LITERAL", 
		"STRINGLIT", "BOOLEAN", "BREAK", "CONTINUE", "ELSE", "FOR", "FLOAT", "IF", 
		"INT", "RETURN", "VOID", "DO", "WHILE", "TRUE", "FALSE", "STRING", "ADD", 
		"SUB", "MUL", "FDIV", "NOT", "MOD", "OR", "AND", "NEQU", "EQU", "LT", 
		"GT", "LE", "GE", "ASSIGN", "LB", "RB", "LP", "RP", "LSB", "RSB", "SEMI", 
		"COLON", "COMMA", "LF", "WS", "IDENTIFIERS", "ERROR_CHAR", "UNCLOSE_STRING", 
		"ILLEGAL_ESCAPE"
	};
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
	public Token emit() {
	    switch (getType()) {
	    case UNCLOSE_STRING:       
	        Token result = super.emit();
	        // you'll need to define this method
	        throw new UncloseString(result.getText());
	        
	    case ILLEGAL_ESCAPE:
	    	result = super.emit();
	    	throw new IllegalEscape(result.getText());

	    case ERROR_CHAR:
	    	result = super.emit();
	    	throw new ErrorToken(result.getText());	

	    default:
	        return super.emit();
	    }
	}


	public MCLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\65\u018f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\3\2\3\2\3\2\3\2"+
		"\7\2z\n\2\f\2\16\2}\13\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3\u0088"+
		"\n\3\f\3\16\3\u008b\13\3\3\3\5\3\u008e\n\3\3\3\5\3\u0091\n\3\3\3\3\3\3"+
		"\4\6\4\u0096\n\4\r\4\16\4\u0097\3\5\3\5\5\5\u009c\n\5\3\5\6\5\u009f\n"+
		"\5\r\5\16\5\u00a0\3\5\3\5\5\5\u00a5\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\5\6\u00b0\n\6\3\7\3\7\3\7\3\7\7\7\u00b6\n\7\f\7\16\7\u00b9\13\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37"+
		"\3\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3&\3&\3\'\3"+
		"\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3/\3\60\6\60\u014b"+
		"\n\60\r\60\16\60\u014c\3\60\3\60\3\61\3\61\7\61\u0153\n\61\f\61\16\61"+
		"\u0156\13\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\6\66\u0161\n"+
		"\66\r\66\16\66\u0162\3\66\3\66\7\66\u0167\n\66\f\66\16\66\u016a\13\66"+
		"\3\66\7\66\u016d\n\66\f\66\16\66\u0170\13\66\3\66\3\66\6\66\u0174\n\66"+
		"\r\66\16\66\u0175\5\66\u0178\n\66\3\67\3\67\5\67\u017c\n\67\3\67\6\67"+
		"\u017f\n\67\r\67\16\67\u0180\38\38\39\39\39\39\79\u0189\n9\f9\169\u018c"+
		"\139\3:\3:\4{\u0089\2;\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\2"+
		"e\2g\2i\2k\2m\2o\63q\64s\65\3\2\r\4\2\f\f\17\17\3\3\f\f\n\2$$))^^ddhh"+
		"ppttvv\6\2\f\f\17\17$$^^\5\2\13\f\17\17\"\"\5\2C\\aac|\6\2\62;C\\aac|"+
		"\3\2c|\3\2C\\\3\2\62;\4\2GGgg\u019d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2"+
		"\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2["+
		"\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2"+
		"\2\2\3u\3\2\2\2\5\u0083\3\2\2\2\7\u0095\3\2\2\2\t\u00a4\3\2\2\2\13\u00af"+
		"\3\2\2\2\r\u00b1\3\2\2\2\17\u00bc\3\2\2\2\21\u00c4\3\2\2\2\23\u00ca\3"+
		"\2\2\2\25\u00d3\3\2\2\2\27\u00d8\3\2\2\2\31\u00dc\3\2\2\2\33\u00e2\3\2"+
		"\2\2\35\u00e5\3\2\2\2\37\u00e9\3\2\2\2!\u00f0\3\2\2\2#\u00f5\3\2\2\2%"+
		"\u00f8\3\2\2\2\'\u00fe\3\2\2\2)\u0103\3\2\2\2+\u0109\3\2\2\2-\u0110\3"+
		"\2\2\2/\u0112\3\2\2\2\61\u0114\3\2\2\2\63\u0116\3\2\2\2\65\u0118\3\2\2"+
		"\2\67\u011a\3\2\2\29\u011c\3\2\2\2;\u011f\3\2\2\2=\u0122\3\2\2\2?\u0125"+
		"\3\2\2\2A\u0128\3\2\2\2C\u012a\3\2\2\2E\u012c\3\2\2\2G\u012f\3\2\2\2I"+
		"\u0132\3\2\2\2K\u0134\3\2\2\2M\u0136\3\2\2\2O\u0138\3\2\2\2Q\u013a\3\2"+
		"\2\2S\u013c\3\2\2\2U\u013e\3\2\2\2W\u0140\3\2\2\2Y\u0142\3\2\2\2[\u0144"+
		"\3\2\2\2]\u0146\3\2\2\2_\u014a\3\2\2\2a\u0150\3\2\2\2c\u0157\3\2\2\2e"+
		"\u0159\3\2\2\2g\u015b\3\2\2\2i\u015d\3\2\2\2k\u0177\3\2\2\2m\u0179\3\2"+
		"\2\2o\u0182\3\2\2\2q\u0184\3\2\2\2s\u018d\3\2\2\2uv\7\61\2\2vw\7,\2\2"+
		"w{\3\2\2\2xz\13\2\2\2yx\3\2\2\2z}\3\2\2\2{|\3\2\2\2{y\3\2\2\2|~\3\2\2"+
		"\2}{\3\2\2\2~\177\7,\2\2\177\u0080\7\61\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\u0082\b\2\2\2\u0082\4\3\2\2\2\u0083\u0084\7\61\2\2\u0084\u0085\7\61\2"+
		"\2\u0085\u0089\3\2\2\2\u0086\u0088\n\2\2\2\u0087\u0086\3\2\2\2\u0088\u008b"+
		"\3\2\2\2\u0089\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008d\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008c\u008e\7\17\2\2\u008d\u008c\3\2\2\2\u008d\u008e\3"+
		"\2\2\2\u008e\u0090\3\2\2\2\u008f\u0091\t\3\2\2\u0090\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0093\b\3\2\2\u0093\6\3\2\2\2\u0094\u0096\5g\64\2"+
		"\u0095\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098"+
		"\3\2\2\2\u0098\b\3\2\2\2\u0099\u009b\5k\66\2\u009a\u009c\5m\67\2\u009b"+
		"\u009a\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u00a5\3\2\2\2\u009d\u009f\5g"+
		"\64\2\u009e\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\5m\67\2\u00a3\u00a5\3\2"+
		"\2\2\u00a4\u0099\3\2\2\2\u00a4\u009e\3\2\2\2\u00a5\n\3\2\2\2\u00a6\u00a7"+
		"\7v\2\2\u00a7\u00a8\7t\2\2\u00a8\u00a9\7w\2\2\u00a9\u00b0\7g\2\2\u00aa"+
		"\u00ab\7h\2\2\u00ab\u00ac\7c\2\2\u00ac\u00ad\7n\2\2\u00ad\u00ae\7u\2\2"+
		"\u00ae\u00b0\7g\2\2\u00af\u00a6\3\2\2\2\u00af\u00aa\3\2\2\2\u00b0\f\3"+
		"\2\2\2\u00b1\u00b7\7$\2\2\u00b2\u00b3\7^\2\2\u00b3\u00b6\t\4\2\2\u00b4"+
		"\u00b6\n\5\2\2\u00b5\u00b2\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b9\3\2"+
		"\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9"+
		"\u00b7\3\2\2\2\u00ba\u00bb\7$\2\2\u00bb\16\3\2\2\2\u00bc\u00bd\7d\2\2"+
		"\u00bd\u00be\7q\2\2\u00be\u00bf\7q\2\2\u00bf\u00c0\7n\2\2\u00c0\u00c1"+
		"\7g\2\2\u00c1\u00c2\7c\2\2\u00c2\u00c3\7p\2\2\u00c3\20\3\2\2\2\u00c4\u00c5"+
		"\7d\2\2\u00c5\u00c6\7t\2\2\u00c6\u00c7\7g\2\2\u00c7\u00c8\7c\2\2\u00c8"+
		"\u00c9\7m\2\2\u00c9\22\3\2\2\2\u00ca\u00cb\7e\2\2\u00cb\u00cc\7q\2\2\u00cc"+
		"\u00cd\7p\2\2\u00cd\u00ce\7v\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d0\7p\2\2"+
		"\u00d0\u00d1\7w\2\2\u00d1\u00d2\7g\2\2\u00d2\24\3\2\2\2\u00d3\u00d4\7"+
		"g\2\2\u00d4\u00d5\7n\2\2\u00d5\u00d6\7u\2\2\u00d6\u00d7\7g\2\2\u00d7\26"+
		"\3\2\2\2\u00d8\u00d9\7h\2\2\u00d9\u00da\7q\2\2\u00da\u00db\7t\2\2\u00db"+
		"\30\3\2\2\2\u00dc\u00dd\7h\2\2\u00dd\u00de\7n\2\2\u00de\u00df\7q\2\2\u00df"+
		"\u00e0\7c\2\2\u00e0\u00e1\7v\2\2\u00e1\32\3\2\2\2\u00e2\u00e3\7k\2\2\u00e3"+
		"\u00e4\7h\2\2\u00e4\34\3\2\2\2\u00e5\u00e6\7k\2\2\u00e6\u00e7\7p\2\2\u00e7"+
		"\u00e8\7v\2\2\u00e8\36\3\2\2\2\u00e9\u00ea\7t\2\2\u00ea\u00eb\7g\2\2\u00eb"+
		"\u00ec\7v\2\2\u00ec\u00ed\7w\2\2\u00ed\u00ee\7t\2\2\u00ee\u00ef\7p\2\2"+
		"\u00ef \3\2\2\2\u00f0\u00f1\7x\2\2\u00f1\u00f2\7q\2\2\u00f2\u00f3\7k\2"+
		"\2\u00f3\u00f4\7f\2\2\u00f4\"\3\2\2\2\u00f5\u00f6\7f\2\2\u00f6\u00f7\7"+
		"q\2\2\u00f7$\3\2\2\2\u00f8\u00f9\7y\2\2\u00f9\u00fa\7j\2\2\u00fa\u00fb"+
		"\7k\2\2\u00fb\u00fc\7n\2\2\u00fc\u00fd\7g\2\2\u00fd&\3\2\2\2\u00fe\u00ff"+
		"\7v\2\2\u00ff\u0100\7t\2\2\u0100\u0101\7w\2\2\u0101\u0102\7g\2\2\u0102"+
		"(\3\2\2\2\u0103\u0104\7h\2\2\u0104\u0105\7c\2\2\u0105\u0106\7n\2\2\u0106"+
		"\u0107\7u\2\2\u0107\u0108\7g\2\2\u0108*\3\2\2\2\u0109\u010a\7u\2\2\u010a"+
		"\u010b\7v\2\2\u010b\u010c\7t\2\2\u010c\u010d\7k\2\2\u010d\u010e\7p\2\2"+
		"\u010e\u010f\7i\2\2\u010f,\3\2\2\2\u0110\u0111\7-\2\2\u0111.\3\2\2\2\u0112"+
		"\u0113\7/\2\2\u0113\60\3\2\2\2\u0114\u0115\7,\2\2\u0115\62\3\2\2\2\u0116"+
		"\u0117\7\61\2\2\u0117\64\3\2\2\2\u0118\u0119\7#\2\2\u0119\66\3\2\2\2\u011a"+
		"\u011b\7\'\2\2\u011b8\3\2\2\2\u011c\u011d\7~\2\2\u011d\u011e\7~\2\2\u011e"+
		":\3\2\2\2\u011f\u0120\7(\2\2\u0120\u0121\7(\2\2\u0121<\3\2\2\2\u0122\u0123"+
		"\7#\2\2\u0123\u0124\7?\2\2\u0124>\3\2\2\2\u0125\u0126\7?\2\2\u0126\u0127"+
		"\7?\2\2\u0127@\3\2\2\2\u0128\u0129\7>\2\2\u0129B\3\2\2\2\u012a\u012b\7"+
		"@\2\2\u012bD\3\2\2\2\u012c\u012d\7>\2\2\u012d\u012e\7?\2\2\u012eF\3\2"+
		"\2\2\u012f\u0130\7@\2\2\u0130\u0131\7?\2\2\u0131H\3\2\2\2\u0132\u0133"+
		"\7?\2\2\u0133J\3\2\2\2\u0134\u0135\7*\2\2\u0135L\3\2\2\2\u0136\u0137\7"+
		"+\2\2\u0137N\3\2\2\2\u0138\u0139\7}\2\2\u0139P\3\2\2\2\u013a\u013b\7\177"+
		"\2\2\u013bR\3\2\2\2\u013c\u013d\7]\2\2\u013dT\3\2\2\2\u013e\u013f\7_\2"+
		"\2\u013fV\3\2\2\2\u0140\u0141\7=\2\2\u0141X\3\2\2\2\u0142\u0143\7<\2\2"+
		"\u0143Z\3\2\2\2\u0144\u0145\7.\2\2\u0145\\\3\2\2\2\u0146\u0147\7^\2\2"+
		"\u0147\u0148\7p\2\2\u0148^\3\2\2\2\u0149\u014b\t\6\2\2\u014a\u0149\3\2"+
		"\2\2\u014b\u014c\3\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d"+
		"\u014e\3\2\2\2\u014e\u014f\b\60\2\2\u014f`\3\2\2\2\u0150\u0154\t\7\2\2"+
		"\u0151\u0153\t\b\2\2\u0152\u0151\3\2\2\2\u0153\u0156\3\2\2\2\u0154\u0152"+
		"\3\2\2\2\u0154\u0155\3\2\2\2\u0155b\3\2\2\2\u0156\u0154\3\2\2\2\u0157"+
		"\u0158\t\t\2\2\u0158d\3\2\2\2\u0159\u015a\t\n\2\2\u015af\3\2\2\2\u015b"+
		"\u015c\t\13\2\2\u015ch\3\2\2\2\u015d\u015e\7a\2\2\u015ej\3\2\2\2\u015f"+
		"\u0161\5g\64\2\u0160\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0160\3\2"+
		"\2\2\u0162\u0163\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0168\7\60\2\2\u0165"+
		"\u0167\5g\64\2\u0166\u0165\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0166\3\2"+
		"\2\2\u0168\u0169\3\2\2\2\u0169\u0178\3\2\2\2\u016a\u0168\3\2\2\2\u016b"+
		"\u016d\5g\64\2\u016c\u016b\3\2\2\2\u016d\u0170\3\2\2\2\u016e\u016c\3\2"+
		"\2\2\u016e\u016f\3\2\2\2\u016f\u0171\3\2\2\2\u0170\u016e\3\2\2\2\u0171"+
		"\u0173\7\60\2\2\u0172\u0174\5g\64\2\u0173\u0172\3\2\2\2\u0174\u0175\3"+
		"\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0178\3\2\2\2\u0177"+
		"\u0160\3\2\2\2\u0177\u016e\3\2\2\2\u0178l\3\2\2\2\u0179\u017b\t\f\2\2"+
		"\u017a\u017c\7/\2\2\u017b\u017a\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017e"+
		"\3\2\2\2\u017d\u017f\5g\64\2\u017e\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180"+
		"\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181n\3\2\2\2\u0182\u0183\13\2\2\2"+
		"\u0183p\3\2\2\2\u0184\u018a\7$\2\2\u0185\u0186\7^\2\2\u0186\u0189\t\4"+
		"\2\2\u0187\u0189\n\5\2\2\u0188\u0185\3\2\2\2\u0188\u0187\3\2\2\2\u0189"+
		"\u018c\3\2\2\2\u018a\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018br\3\2\2\2"+
		"\u018c\u018a\3\2\2\2\u018d\u018e\13\2\2\2\u018et\3\2\2\2\31\2{\u0089\u008d"+
		"\u0090\u0097\u009b\u00a0\u00a4\u00af\u00b5\u00b7\u014c\u0154\u0162\u0168"+
		"\u016e\u0175\u0177\u017b\u0180\u0188\u018a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}