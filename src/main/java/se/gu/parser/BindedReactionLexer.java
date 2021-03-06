// Generated from BindedReaction.g4 by ANTLR 4.4

 	
 	package se.gu.parser;
 

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BindedReactionLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__9=1, T__8=2, T__7=3, T__6=4, T__5=5, T__4=6, T__3=7, T__2=8, T__1=9, 
		T__0=10, GLOBALLY=11, PREV=12, YESTERDAY=13, GLOBALLYFINALLY=14, FINALLY=15, 
		NEXT=16, TEXTUALNEXT=17, NEG=18, LPAR=19, RPAR=20, EQUAL=21, MINUS=22, 
		WS=23, ID=24, CONSTANT=25, NAT=26, STAR=27, LBRACK=28, RBRACK=29, TRUE=30, 
		FALSE=31, NEWLINE=32, COMMA=33, COMMENT=34, LINE_COMMENT=35;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'"
	};
	public static final String[] ruleNames = {
		"T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", 
		"T__0", "GLOBALLY", "PREV", "YESTERDAY", "GLOBALLYFINALLY", "FINALLY", 
		"NEXT", "TEXTUALNEXT", "NEG", "LPAR", "RPAR", "EQUAL", "MINUS", "WS", 
		"ID", "CONSTANT", "NAT", "STAR", "LBRACK", "RBRACK", "TRUE", "FALSE", 
		"NEWLINE", "COMMA", "COMMENT", "LINE_COMMENT"
	};

	  boolean matchedEOF=false;
	 	
	 	
	 

	public BindedReactionLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BindedReaction.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2%\u00e1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27"+
		"\3\30\6\30\u0084\n\30\r\30\16\30\u0085\3\30\3\30\3\31\3\31\7\31\u008c"+
		"\n\31\f\31\16\31\u008f\13\31\3\31\3\31\3\31\3\31\5\31\u0095\n\31\3\31"+
		"\3\31\3\31\3\31\3\31\5\31\u009c\n\31\5\31\u009e\n\31\3\32\3\32\7\32\u00a2"+
		"\n\32\f\32\16\32\u00a5\13\32\3\33\5\33\u00a8\n\33\3\33\3\33\7\33\u00ac"+
		"\n\33\f\33\16\33\u00af\13\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3"+
		"\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\5!\u00c3\n!\3!\3!\3\"\3\"\3#\3#\3#"+
		"\3#\7#\u00cd\n#\f#\16#\u00d0\13#\3#\3#\3#\3#\3#\3$\3$\3$\3$\7$\u00db\n"+
		"$\f$\16$\u00de\13$\3$\3$\3\u00ce\2%\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%\3\2\7\5\2\13\f\17\17"+
		"\"\"\6\2&&C\\aac|\7\2&&\62;C\\aac|\6\2\62;C\\aac|\4\2\f\f\17\17\u00ec"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\3I\3\2\2\2\5L\3\2\2\2\7O\3\2\2\2\tQ\3\2\2\2\13T\3\2\2\2\rV\3\2\2\2"+
		"\17X\3\2\2\2\21[\3\2\2\2\23]\3\2\2\2\25_\3\2\2\2\27c\3\2\2\2\31e\3\2\2"+
		"\2\33j\3\2\2\2\35l\3\2\2\2\37o\3\2\2\2!q\3\2\2\2#s\3\2\2\2%x\3\2\2\2\'"+
		"z\3\2\2\2)|\3\2\2\2+~\3\2\2\2-\u0080\3\2\2\2/\u0083\3\2\2\2\61\u0089\3"+
		"\2\2\2\63\u009f\3\2\2\2\65\u00a7\3\2\2\2\67\u00b0\3\2\2\29\u00b2\3\2\2"+
		"\2;\u00b4\3\2\2\2=\u00b6\3\2\2\2?\u00bb\3\2\2\2A\u00c2\3\2\2\2C\u00c6"+
		"\3\2\2\2E\u00c8\3\2\2\2G\u00d6\3\2\2\2IJ\7#\2\2JK\7?\2\2K\4\3\2\2\2LM"+
		"\7@\2\2MN\7?\2\2N\6\3\2\2\2OP\7>\2\2P\b\3\2\2\2QR\7?\2\2RS\7?\2\2S\n\3"+
		"\2\2\2TU\7~\2\2U\f\3\2\2\2VW\7@\2\2W\16\3\2\2\2XY\7>\2\2YZ\7?\2\2Z\20"+
		"\3\2\2\2[\\\7(\2\2\\\22\3\2\2\2]^\7-\2\2^\24\3\2\2\2_`\7>\2\2`a\7/\2\2"+
		"ab\7@\2\2b\26\3\2\2\2cd\7I\2\2d\30\3\2\2\2ef\7R\2\2fg\7T\2\2gh\7G\2\2"+
		"hi\7X\2\2i\32\3\2\2\2jk\7[\2\2k\34\3\2\2\2lm\7I\2\2mn\7H\2\2n\36\3\2\2"+
		"\2op\7H\2\2p \3\2\2\2qr\7z\2\2r\"\3\2\2\2st\7p\2\2tu\7g\2\2uv\7z\2\2v"+
		"w\7v\2\2w$\3\2\2\2xy\7#\2\2y&\3\2\2\2z{\7*\2\2{(\3\2\2\2|}\7+\2\2}*\3"+
		"\2\2\2~\177\7?\2\2\177,\3\2\2\2\u0080\u0081\7/\2\2\u0081.\3\2\2\2\u0082"+
		"\u0084\t\2\2\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083\3\2"+
		"\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\b\30\2\2\u0088"+
		"\60\3\2\2\2\u0089\u008d\t\3\2\2\u008a\u008c\t\4\2\2\u008b\u008a\3\2\2"+
		"\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u009d"+
		"\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0091\59\35\2\u0091\u0092\5\65\33\2"+
		"\u0092\u0093\5;\36\2\u0093\u0095\3\2\2\2\u0094\u0090\3\2\2\2\u0094\u0095"+
		"\3\2\2\2\u0095\u009e\3\2\2\2\u0096\u009e\3\2\2\2\u0097\u0098\5\'\24\2"+
		"\u0098\u0099\5\65\33\2\u0099\u009a\5)\25\2\u009a\u009c\3\2\2\2\u009b\u0097"+
		"\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e\3\2\2\2\u009d\u0094\3\2\2\2\u009d"+
		"\u0096\3\2\2\2\u009d\u009b\3\2\2\2\u009e\62\3\2\2\2\u009f\u00a3\4C\\\2"+
		"\u00a0\u00a2\t\5\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\64\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6"+
		"\u00a8\7/\2\2\u00a7\u00a6\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\3\2"+
		"\2\2\u00a9\u00ad\4\62;\2\u00aa\u00ac\4\62;\2\u00ab\u00aa\3\2\2\2\u00ac"+
		"\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\66\3\2\2"+
		"\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\7,\2\2\u00b18\3\2\2\2\u00b2\u00b3\7"+
		"]\2\2\u00b3:\3\2\2\2\u00b4\u00b5\7_\2\2\u00b5<\3\2\2\2\u00b6\u00b7\7v"+
		"\2\2\u00b7\u00b8\7t\2\2\u00b8\u00b9\7w\2\2\u00b9\u00ba\7g\2\2\u00ba>\3"+
		"\2\2\2\u00bb\u00bc\7h\2\2\u00bc\u00bd\7c\2\2\u00bd\u00be\7n\2\2\u00be"+
		"\u00bf\7u\2\2\u00bf\u00c0\7g\2\2\u00c0@\3\2\2\2\u00c1\u00c3\7\17\2\2\u00c2"+
		"\u00c1\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\7\f"+
		"\2\2\u00c5B\3\2\2\2\u00c6\u00c7\7.\2\2\u00c7D\3\2\2\2\u00c8\u00c9\7\61"+
		"\2\2\u00c9\u00ca\7,\2\2\u00ca\u00ce\3\2\2\2\u00cb\u00cd\13\2\2\2\u00cc"+
		"\u00cb\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cf\3\2\2\2\u00ce\u00cc\3\2"+
		"\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\7,\2\2\u00d2"+
		"\u00d3\7\61\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\b#\2\2\u00d5F\3\2\2\2"+
		"\u00d6\u00d7\7\61\2\2\u00d7\u00d8\7\61\2\2\u00d8\u00dc\3\2\2\2\u00d9\u00db"+
		"\n\6\2\2\u00da\u00d9\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc"+
		"\u00dd\3\2\2\2\u00dd\u00df\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00e0\b$"+
		"\2\2\u00e0H\3\2\2\2\16\2\u0085\u008d\u0094\u009b\u009d\u00a3\u00a7\u00ad"+
		"\u00c2\u00ce\u00dc\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}