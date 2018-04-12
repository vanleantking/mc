// Generated from src/main/mc/parser/MC.g4 by ANTLR 4.6

	package mc.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MCParser extends Parser {
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
	public static final int
		RULE_program = 0, RULE_one_decl = 1, RULE_var_decl = 2, RULE_variable = 3, 
		RULE_type = 4, RULE_func_decl = 5, RULE_function_type = 6, RULE_list_parameter_decl = 7, 
		RULE_parameter_decl = 8, RULE_array_type = 9, RULE_array_pointer_type = 10, 
		RULE_input_param_pointer = 11, RULE_output_param_pointer = 12, RULE_expr = 13, 
		RULE_term1 = 14, RULE_term2 = 15, RULE_term3 = 16, RULE_term4 = 17, RULE_term5 = 18, 
		RULE_term6 = 19, RULE_term7 = 20, RULE_term8 = 21, RULE_term9 = 22, RULE_function_call = 23, 
		RULE_expr_list = 24, RULE_statement = 25, RULE_if_statement = 26, RULE_do_statement = 27, 
		RULE_for_statement = 28, RULE_break_statement = 29, RULE_continue_statement = 30, 
		RULE_return_statement = 31, RULE_expr_statement = 32, RULE_block_statement = 33, 
		RULE_primitivetype = 34;
	public static final String[] ruleNames = {
		"program", "one_decl", "var_decl", "variable", "type", "func_decl", "function_type", 
		"list_parameter_decl", "parameter_decl", "array_type", "array_pointer_type", 
		"input_param_pointer", "output_param_pointer", "expr", "term1", "term2", 
		"term3", "term4", "term5", "term6", "term7", "term8", "term9", "function_call", 
		"expr_list", "statement", "if_statement", "do_statement", "for_statement", 
		"break_statement", "continue_statement", "return_statement", "expr_statement", 
		"block_statement", "primitivetype"
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
	public String getGrammarFileName() { return "MC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MCParser.EOF, 0); }
		public List<One_declContext> one_decl() {
			return getRuleContexts(One_declContext.class);
		}
		public One_declContext one_decl(int i) {
			return getRuleContext(One_declContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(70);
				one_decl();
				}
				}
				setState(73); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << FLOAT) | (1L << INT) | (1L << VOID) | (1L << STRING))) != 0) );
			setState(75);
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

	public static class One_declContext extends ParserRuleContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Func_declContext func_decl() {
			return getRuleContext(Func_declContext.class,0);
		}
		public One_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_one_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitOne_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final One_declContext one_decl() throws RecognitionException {
		One_declContext _localctx = new One_declContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_one_decl);
		try {
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				var_decl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				func_decl();
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

	public static class Var_declContext extends ParserRuleContext {
		public PrimitivetypeContext primitivetype() {
			return getRuleContext(PrimitivetypeContext.class,0);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(MCParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MCParser.COMMA, i);
		}
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitVar_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			primitivetype();
			setState(82);
			variable();
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(83);
				match(COMMA);
				setState(84);
				variable();
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(90);
			match(SEMI);
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode IDENTIFIERS() { return getToken(MCParser.IDENTIFIERS, 0); }
		public TerminalNode LSB() { return getToken(MCParser.LSB, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RSB() { return getToken(MCParser.RSB, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(IDENTIFIERS);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSB) {
				{
				setState(93);
				match(LSB);
				setState(94);
				expr();
				setState(95);
				match(RSB);
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

	public static class TypeContext extends ParserRuleContext {
		public PrimitivetypeContext primitivetype() {
			return getRuleContext(PrimitivetypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(MCParser.VOID, 0); }
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Array_pointer_typeContext array_pointer_type() {
			return getRuleContext(Array_pointer_typeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		try {
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				primitivetype();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				match(VOID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				array_type();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(102);
				array_pointer_type();
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

	public static class Func_declContext extends ParserRuleContext {
		public Function_typeContext function_type() {
			return getRuleContext(Function_typeContext.class,0);
		}
		public TerminalNode IDENTIFIERS() { return getToken(MCParser.IDENTIFIERS, 0); }
		public TerminalNode LB() { return getToken(MCParser.LB, 0); }
		public TerminalNode RB() { return getToken(MCParser.RB, 0); }
		public Block_statementContext block_statement() {
			return getRuleContext(Block_statementContext.class,0);
		}
		public List_parameter_declContext list_parameter_decl() {
			return getRuleContext(List_parameter_declContext.class,0);
		}
		public Func_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitFunc_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_declContext func_decl() throws RecognitionException {
		Func_declContext _localctx = new Func_declContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_func_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			function_type();
			setState(106);
			match(IDENTIFIERS);
			setState(107);
			match(LB);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << FLOAT) | (1L << INT) | (1L << STRING))) != 0)) {
				{
				setState(108);
				list_parameter_decl();
				}
			}

			setState(111);
			match(RB);
			setState(112);
			block_statement();
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

	public static class Function_typeContext extends ParserRuleContext {
		public Array_pointer_typeContext array_pointer_type() {
			return getRuleContext(Array_pointer_typeContext.class,0);
		}
		public PrimitivetypeContext primitivetype() {
			return getRuleContext(PrimitivetypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(MCParser.VOID, 0); }
		public Function_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitFunction_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_typeContext function_type() throws RecognitionException {
		Function_typeContext _localctx = new Function_typeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_function_type);
		try {
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				array_pointer_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				primitivetype();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				match(VOID);
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

	public static class List_parameter_declContext extends ParserRuleContext {
		public List<Parameter_declContext> parameter_decl() {
			return getRuleContexts(Parameter_declContext.class);
		}
		public Parameter_declContext parameter_decl(int i) {
			return getRuleContext(Parameter_declContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MCParser.COMMA, i);
		}
		public List_parameter_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_parameter_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitList_parameter_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_parameter_declContext list_parameter_decl() throws RecognitionException {
		List_parameter_declContext _localctx = new List_parameter_declContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_list_parameter_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			parameter_decl();
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(120);
				match(COMMA);
				setState(121);
				parameter_decl();
				}
				}
				setState(126);
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

	public static class Parameter_declContext extends ParserRuleContext {
		public PrimitivetypeContext primitivetype() {
			return getRuleContext(PrimitivetypeContext.class,0);
		}
		public TerminalNode IDENTIFIERS() { return getToken(MCParser.IDENTIFIERS, 0); }
		public TerminalNode LSB() { return getToken(MCParser.LSB, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RSB() { return getToken(MCParser.RSB, 0); }
		public Parameter_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitParameter_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_declContext parameter_decl() throws RecognitionException {
		Parameter_declContext _localctx = new Parameter_declContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameter_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			primitivetype();
			setState(128);
			match(IDENTIFIERS);
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSB) {
				{
				setState(129);
				match(LSB);
				setState(130);
				expr();
				setState(131);
				match(RSB);
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

	public static class Array_typeContext extends ParserRuleContext {
		public PrimitivetypeContext primitivetype() {
			return getRuleContext(PrimitivetypeContext.class,0);
		}
		public TerminalNode LSB() { return getToken(MCParser.LSB, 0); }
		public TerminalNode INTLIT() { return getToken(MCParser.INTLIT, 0); }
		public TerminalNode RSB() { return getToken(MCParser.RSB, 0); }
		public Array_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitArray_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_typeContext array_type() throws RecognitionException {
		Array_typeContext _localctx = new Array_typeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_array_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			primitivetype();
			setState(136);
			match(LSB);
			setState(137);
			match(INTLIT);
			setState(138);
			match(RSB);
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

	public static class Array_pointer_typeContext extends ParserRuleContext {
		public Input_param_pointerContext input_param_pointer() {
			return getRuleContext(Input_param_pointerContext.class,0);
		}
		public Output_param_pointerContext output_param_pointer() {
			return getRuleContext(Output_param_pointerContext.class,0);
		}
		public Array_pointer_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_pointer_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitArray_pointer_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_pointer_typeContext array_pointer_type() throws RecognitionException {
		Array_pointer_typeContext _localctx = new Array_pointer_typeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_array_pointer_type);
		try {
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				input_param_pointer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				output_param_pointer();
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

	public static class Input_param_pointerContext extends ParserRuleContext {
		public PrimitivetypeContext primitivetype() {
			return getRuleContext(PrimitivetypeContext.class,0);
		}
		public TerminalNode IDENTIFIERS() { return getToken(MCParser.IDENTIFIERS, 0); }
		public TerminalNode LSB() { return getToken(MCParser.LSB, 0); }
		public TerminalNode RSB() { return getToken(MCParser.RSB, 0); }
		public Input_param_pointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input_param_pointer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitInput_param_pointer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Input_param_pointerContext input_param_pointer() throws RecognitionException {
		Input_param_pointerContext _localctx = new Input_param_pointerContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_input_param_pointer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			primitivetype();
			setState(145);
			match(IDENTIFIERS);
			setState(146);
			match(LSB);
			setState(147);
			match(RSB);
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

	public static class Output_param_pointerContext extends ParserRuleContext {
		public PrimitivetypeContext primitivetype() {
			return getRuleContext(PrimitivetypeContext.class,0);
		}
		public TerminalNode LSB() { return getToken(MCParser.LSB, 0); }
		public TerminalNode RSB() { return getToken(MCParser.RSB, 0); }
		public Output_param_pointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_output_param_pointer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitOutput_param_pointer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Output_param_pointerContext output_param_pointer() throws RecognitionException {
		Output_param_pointerContext _localctx = new Output_param_pointerContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_output_param_pointer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			primitivetype();
			setState(150);
			match(LSB);
			setState(151);
			match(RSB);
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

	public static class ExprContext extends ParserRuleContext {
		public Term1Context term1() {
			return getRuleContext(Term1Context.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expr);
		try {
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				term1(0);
				setState(154);
				match(ASSIGN);
				setState(155);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				term1(0);
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

	public static class Term1Context extends ParserRuleContext {
		public Term2Context term2() {
			return getRuleContext(Term2Context.class,0);
		}
		public Term1Context term1() {
			return getRuleContext(Term1Context.class,0);
		}
		public Term1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term1; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitTerm1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Term1Context term1() throws RecognitionException {
		return term1(0);
	}

	private Term1Context term1(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Term1Context _localctx = new Term1Context(_ctx, _parentState);
		Term1Context _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_term1, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(161);
			term2(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(168);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Term1Context(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_term1);
					setState(163);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(164);
					match(OR);
					setState(165);
					term2(0);
					}
					} 
				}
				setState(170);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class Term2Context extends ParserRuleContext {
		public Term3Context term3() {
			return getRuleContext(Term3Context.class,0);
		}
		public Term2Context term2() {
			return getRuleContext(Term2Context.class,0);
		}
		public Term2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitTerm2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Term2Context term2() throws RecognitionException {
		return term2(0);
	}

	private Term2Context term2(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Term2Context _localctx = new Term2Context(_ctx, _parentState);
		Term2Context _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_term2, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(172);
			term3();
			}
			_ctx.stop = _input.LT(-1);
			setState(179);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Term2Context(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_term2);
					setState(174);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(175);
					match(AND);
					setState(176);
					term3();
					}
					} 
				}
				setState(181);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class Term3Context extends ParserRuleContext {
		public List<Term4Context> term4() {
			return getRuleContexts(Term4Context.class);
		}
		public Term4Context term4(int i) {
			return getRuleContext(Term4Context.class,i);
		}
		public Term3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term3; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitTerm3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Term3Context term3() throws RecognitionException {
		Term3Context _localctx = new Term3Context(_ctx, getState());
		enterRule(_localctx, 32, RULE_term3);
		try {
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				term4();
				setState(183);
				match(EQU);
				setState(184);
				term4();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				term4();
				setState(187);
				match(NEQU);
				setState(188);
				term4();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(190);
				term4();
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

	public static class Term4Context extends ParserRuleContext {
		public List<Term5Context> term5() {
			return getRuleContexts(Term5Context.class);
		}
		public Term5Context term5(int i) {
			return getRuleContext(Term5Context.class,i);
		}
		public Term4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term4; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitTerm4(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Term4Context term4() throws RecognitionException {
		Term4Context _localctx = new Term4Context(_ctx, getState());
		enterRule(_localctx, 34, RULE_term4);
		try {
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				term5(0);
				setState(194);
				match(LT);
				setState(195);
				term5(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				term5(0);
				setState(198);
				match(LE);
				setState(199);
				term5(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				term5(0);
				setState(202);
				match(GT);
				setState(203);
				term5(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(205);
				term5(0);
				setState(206);
				match(GE);
				setState(207);
				term5(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(209);
				term5(0);
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

	public static class Term5Context extends ParserRuleContext {
		public Term6Context term6() {
			return getRuleContext(Term6Context.class,0);
		}
		public Term5Context term5() {
			return getRuleContext(Term5Context.class,0);
		}
		public Term5Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term5; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitTerm5(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Term5Context term5() throws RecognitionException {
		return term5(0);
	}

	private Term5Context term5(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Term5Context _localctx = new Term5Context(_ctx, _parentState);
		Term5Context _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_term5, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(213);
			term6(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(223);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(221);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new Term5Context(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_term5);
						setState(215);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(216);
						match(ADD);
						setState(217);
						term6(0);
						}
						break;
					case 2:
						{
						_localctx = new Term5Context(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_term5);
						setState(218);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(219);
						match(SUB);
						setState(220);
						term6(0);
						}
						break;
					}
					} 
				}
				setState(225);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	public static class Term6Context extends ParserRuleContext {
		public Term7Context term7() {
			return getRuleContext(Term7Context.class,0);
		}
		public Term6Context term6() {
			return getRuleContext(Term6Context.class,0);
		}
		public Term6Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term6; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitTerm6(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Term6Context term6() throws RecognitionException {
		return term6(0);
	}

	private Term6Context term6(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Term6Context _localctx = new Term6Context(_ctx, _parentState);
		Term6Context _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_term6, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(227);
			term7();
			}
			_ctx.stop = _input.LT(-1);
			setState(240);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(238);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new Term6Context(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_term6);
						setState(229);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(230);
						match(FDIV);
						setState(231);
						term7();
						}
						break;
					case 2:
						{
						_localctx = new Term6Context(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_term6);
						setState(232);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(233);
						match(MUL);
						setState(234);
						term7();
						}
						break;
					case 3:
						{
						_localctx = new Term6Context(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_term6);
						setState(235);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(236);
						match(MOD);
						setState(237);
						term7();
						}
						break;
					}
					} 
				}
				setState(242);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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

	public static class Term7Context extends ParserRuleContext {
		public Term7Context term7() {
			return getRuleContext(Term7Context.class,0);
		}
		public Term8Context term8() {
			return getRuleContext(Term8Context.class,0);
		}
		public Term7Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term7; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitTerm7(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Term7Context term7() throws RecognitionException {
		Term7Context _localctx = new Term7Context(_ctx, getState());
		enterRule(_localctx, 40, RULE_term7);
		int _la;
		try {
			setState(246);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUB:
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				_la = _input.LA(1);
				if ( !(_la==SUB || _la==NOT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(244);
				term7();
				}
				break;
			case INTLIT:
			case FLOAT_LITERAL:
			case BOOLEAN_LITERAL:
			case STRINGLIT:
			case LB:
			case IDENTIFIERS:
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				term8();
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

	public static class Term8Context extends ParserRuleContext {
		public Term9Context term9() {
			return getRuleContext(Term9Context.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Term8Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term8; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitTerm8(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Term8Context term8() throws RecognitionException {
		Term8Context _localctx = new Term8Context(_ctx, getState());
		enterRule(_localctx, 42, RULE_term8);
		try {
			setState(254);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				term9();
				setState(249);
				match(LSB);
				setState(250);
				expr();
				setState(251);
				match(RSB);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				term9();
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

	public static class Term9Context extends ParserRuleContext {
		public TerminalNode LB() { return getToken(MCParser.LB, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RB() { return getToken(MCParser.RB, 0); }
		public TerminalNode IDENTIFIERS() { return getToken(MCParser.IDENTIFIERS, 0); }
		public TerminalNode BOOLEAN_LITERAL() { return getToken(MCParser.BOOLEAN_LITERAL, 0); }
		public TerminalNode INTLIT() { return getToken(MCParser.INTLIT, 0); }
		public TerminalNode FLOAT_LITERAL() { return getToken(MCParser.FLOAT_LITERAL, 0); }
		public TerminalNode STRINGLIT() { return getToken(MCParser.STRINGLIT, 0); }
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Term9Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term9; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitTerm9(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Term9Context term9() throws RecognitionException {
		Term9Context _localctx = new Term9Context(_ctx, getState());
		enterRule(_localctx, 44, RULE_term9);
		try {
			setState(266);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(256);
				match(LB);
				setState(257);
				expr();
				setState(258);
				match(RB);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				match(IDENTIFIERS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(261);
				match(BOOLEAN_LITERAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(262);
				match(INTLIT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(263);
				match(FLOAT_LITERAL);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(264);
				match(STRINGLIT);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(265);
				function_call();
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

	public static class Function_callContext extends ParserRuleContext {
		public TerminalNode IDENTIFIERS() { return getToken(MCParser.IDENTIFIERS, 0); }
		public TerminalNode LB() { return getToken(MCParser.LB, 0); }
		public TerminalNode RB() { return getToken(MCParser.RB, 0); }
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(IDENTIFIERS);
			setState(269);
			match(LB);
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTLIT) | (1L << FLOAT_LITERAL) | (1L << BOOLEAN_LITERAL) | (1L << STRINGLIT) | (1L << SUB) | (1L << NOT) | (1L << LB) | (1L << IDENTIFIERS))) != 0)) {
				{
				setState(270);
				expr_list();
				}
			}

			setState(273);
			match(RB);
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

	public static class Expr_listContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MCParser.COMMA, i);
		}
		public Expr_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitExpr_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_listContext expr_list() throws RecognitionException {
		Expr_listContext _localctx = new Expr_listContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expr_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			expr();
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(276);
				match(COMMA);
				setState(277);
				expr();
				}
				}
				setState(282);
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

	public static class StatementContext extends ParserRuleContext {
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public For_statementContext for_statement() {
			return getRuleContext(For_statementContext.class,0);
		}
		public Do_statementContext do_statement() {
			return getRuleContext(Do_statementContext.class,0);
		}
		public Break_statementContext break_statement() {
			return getRuleContext(Break_statementContext.class,0);
		}
		public Continue_statementContext continue_statement() {
			return getRuleContext(Continue_statementContext.class,0);
		}
		public Return_statementContext return_statement() {
			return getRuleContext(Return_statementContext.class,0);
		}
		public Block_statementContext block_statement() {
			return getRuleContext(Block_statementContext.class,0);
		}
		public Expr_statementContext expr_statement() {
			return getRuleContext(Expr_statementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_statement);
		try {
			setState(291);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(283);
				if_statement();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(284);
				for_statement();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 3);
				{
				setState(285);
				do_statement();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 4);
				{
				setState(286);
				break_statement();
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 5);
				{
				setState(287);
				continue_statement();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 6);
				{
				setState(288);
				return_statement();
				}
				break;
			case LP:
				enterOuterAlt(_localctx, 7);
				{
				setState(289);
				block_statement();
				}
				break;
			case INTLIT:
			case FLOAT_LITERAL:
			case BOOLEAN_LITERAL:
			case STRINGLIT:
			case SUB:
			case NOT:
			case LB:
			case IDENTIFIERS:
				enterOuterAlt(_localctx, 8);
				{
				setState(290);
				expr_statement();
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

	public static class If_statementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MCParser.IF, 0); }
		public TerminalNode LB() { return getToken(MCParser.LB, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RB() { return getToken(MCParser.RB, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MCParser.ELSE, 0); }
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitIf_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(IF);
			setState(294);
			match(LB);
			setState(295);
			expr();
			setState(296);
			match(RB);
			setState(297);
			statement();
			setState(300);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(298);
				match(ELSE);
				setState(299);
				statement();
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

	public static class Do_statementContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(MCParser.DO, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MCParser.SEMI, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Do_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_do_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitDo_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Do_statementContext do_statement() throws RecognitionException {
		Do_statementContext _localctx = new Do_statementContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_do_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(DO);
			setState(304); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(303);
				statement();
				}
				}
				setState(306); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTLIT) | (1L << FLOAT_LITERAL) | (1L << BOOLEAN_LITERAL) | (1L << STRINGLIT) | (1L << BREAK) | (1L << CONTINUE) | (1L << FOR) | (1L << IF) | (1L << RETURN) | (1L << DO) | (1L << SUB) | (1L << NOT) | (1L << LB) | (1L << LP) | (1L << IDENTIFIERS))) != 0) );
			setState(308);
			match(WHILE);
			setState(309);
			expr();
			setState(310);
			match(SEMI);
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

	public static class For_statementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MCParser.FOR, 0); }
		public TerminalNode LB() { return getToken(MCParser.LB, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(MCParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MCParser.SEMI, i);
		}
		public TerminalNode RB() { return getToken(MCParser.RB, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public For_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitFor_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_statementContext for_statement() throws RecognitionException {
		For_statementContext _localctx = new For_statementContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_for_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			match(FOR);
			setState(313);
			match(LB);
			setState(314);
			expr();
			setState(315);
			match(SEMI);
			setState(316);
			expr();
			setState(317);
			match(SEMI);
			setState(318);
			expr();
			setState(319);
			match(RB);
			setState(320);
			statement();
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

	public static class Break_statementContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(MCParser.BREAK, 0); }
		public TerminalNode SEMI() { return getToken(MCParser.SEMI, 0); }
		public Break_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_break_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitBreak_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Break_statementContext break_statement() throws RecognitionException {
		Break_statementContext _localctx = new Break_statementContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_break_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			match(BREAK);
			setState(323);
			match(SEMI);
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

	public static class Continue_statementContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(MCParser.CONTINUE, 0); }
		public TerminalNode SEMI() { return getToken(MCParser.SEMI, 0); }
		public Continue_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continue_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitContinue_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Continue_statementContext continue_statement() throws RecognitionException {
		Continue_statementContext _localctx = new Continue_statementContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_continue_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			match(CONTINUE);
			setState(326);
			match(SEMI);
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

	public static class Return_statementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MCParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(MCParser.SEMI, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitReturn_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_statementContext return_statement() throws RecognitionException {
		Return_statementContext _localctx = new Return_statementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_return_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(RETURN);
			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTLIT) | (1L << FLOAT_LITERAL) | (1L << BOOLEAN_LITERAL) | (1L << STRINGLIT) | (1L << SUB) | (1L << NOT) | (1L << LB) | (1L << IDENTIFIERS))) != 0)) {
				{
				setState(329);
				expr();
				}
			}

			setState(332);
			match(SEMI);
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

	public static class Expr_statementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MCParser.SEMI, 0); }
		public Expr_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitExpr_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_statementContext expr_statement() throws RecognitionException {
		Expr_statementContext _localctx = new Expr_statementContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_expr_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			expr();
			setState(335);
			match(SEMI);
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

	public static class Block_statementContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(MCParser.LP, 0); }
		public TerminalNode RP() { return getToken(MCParser.RP, 0); }
		public List<Var_declContext> var_decl() {
			return getRuleContexts(Var_declContext.class);
		}
		public Var_declContext var_decl(int i) {
			return getRuleContext(Var_declContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Block_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitBlock_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Block_statementContext block_statement() throws RecognitionException {
		Block_statementContext _localctx = new Block_statementContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_block_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			match(LP);
			setState(342);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTLIT) | (1L << FLOAT_LITERAL) | (1L << BOOLEAN_LITERAL) | (1L << STRINGLIT) | (1L << BOOLEAN) | (1L << BREAK) | (1L << CONTINUE) | (1L << FOR) | (1L << FLOAT) | (1L << IF) | (1L << INT) | (1L << RETURN) | (1L << DO) | (1L << STRING) | (1L << SUB) | (1L << NOT) | (1L << LB) | (1L << LP) | (1L << IDENTIFIERS))) != 0)) {
				{
				setState(340);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOLEAN:
				case FLOAT:
				case INT:
				case STRING:
					{
					setState(338);
					var_decl();
					}
					break;
				case INTLIT:
				case FLOAT_LITERAL:
				case BOOLEAN_LITERAL:
				case STRINGLIT:
				case BREAK:
				case CONTINUE:
				case FOR:
				case IF:
				case RETURN:
				case DO:
				case SUB:
				case NOT:
				case LB:
				case LP:
				case IDENTIFIERS:
					{
					setState(339);
					statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(345);
			match(RP);
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

	public static class PrimitivetypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MCParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(MCParser.FLOAT, 0); }
		public TerminalNode BOOLEAN() { return getToken(MCParser.BOOLEAN, 0); }
		public TerminalNode STRING() { return getToken(MCParser.STRING, 0); }
		public PrimitivetypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitivetype; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MCVisitor ) return ((MCVisitor<? extends T>)visitor).visitPrimitivetype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitivetypeContext primitivetype() throws RecognitionException {
		PrimitivetypeContext _localctx = new PrimitivetypeContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_primitivetype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << FLOAT) | (1L << INT) | (1L << STRING))) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return term1_sempred((Term1Context)_localctx, predIndex);
		case 15:
			return term2_sempred((Term2Context)_localctx, predIndex);
		case 18:
			return term5_sempred((Term5Context)_localctx, predIndex);
		case 19:
			return term6_sempred((Term6Context)_localctx, predIndex);
		}
		return true;
	}
	private boolean term1_sempred(Term1Context _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean term2_sempred(Term2Context _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean term5_sempred(Term5Context _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean term6_sempred(Term6Context _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\65\u0160\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\6\2J\n\2\r\2\16\2K\3\2\3\2\3\3\3\3\5\3R\n"+
		"\3\3\4\3\4\3\4\3\4\7\4X\n\4\f\4\16\4[\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\5\5d\n\5\3\6\3\6\3\6\3\6\5\6j\n\6\3\7\3\7\3\7\3\7\5\7p\n\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\5\bx\n\b\3\t\3\t\3\t\7\t}\n\t\f\t\16\t\u0080\13\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\5\n\u0088\n\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\5\f"+
		"\u0091\n\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u00a1\n\17\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00a9\n\20\f"+
		"\20\16\20\u00ac\13\20\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00b4\n\21\f"+
		"\21\16\21\u00b7\13\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22"+
		"\u00c2\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\5\23\u00d5\n\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\7\24\u00e0\n\24\f\24\16\24\u00e3\13\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u00f1\n\25\f\25\16"+
		"\25\u00f4\13\25\3\26\3\26\3\26\5\26\u00f9\n\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\5\27\u0101\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\5\30\u010d\n\30\3\31\3\31\3\31\5\31\u0112\n\31\3\31\3\31\3\32\3\32\3"+
		"\32\7\32\u0119\n\32\f\32\16\32\u011c\13\32\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\5\33\u0126\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34"+
		"\u012f\n\34\3\35\3\35\6\35\u0133\n\35\r\35\16\35\u0134\3\35\3\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37"+
		"\3 \3 \3 \3!\3!\5!\u014d\n!\3!\3!\3\"\3\"\3\"\3#\3#\3#\7#\u0157\n#\f#"+
		"\16#\u015a\13#\3#\3#\3$\3$\3$\2\6\36 &(%\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@BDF\2\4\4\2\31\31\34\34\6\2\t\t\16"+
		"\16\20\20\27\27\u016d\2I\3\2\2\2\4Q\3\2\2\2\6S\3\2\2\2\b^\3\2\2\2\ni\3"+
		"\2\2\2\fk\3\2\2\2\16w\3\2\2\2\20y\3\2\2\2\22\u0081\3\2\2\2\24\u0089\3"+
		"\2\2\2\26\u0090\3\2\2\2\30\u0092\3\2\2\2\32\u0097\3\2\2\2\34\u00a0\3\2"+
		"\2\2\36\u00a2\3\2\2\2 \u00ad\3\2\2\2\"\u00c1\3\2\2\2$\u00d4\3\2\2\2&\u00d6"+
		"\3\2\2\2(\u00e4\3\2\2\2*\u00f8\3\2\2\2,\u0100\3\2\2\2.\u010c\3\2\2\2\60"+
		"\u010e\3\2\2\2\62\u0115\3\2\2\2\64\u0125\3\2\2\2\66\u0127\3\2\2\28\u0130"+
		"\3\2\2\2:\u013a\3\2\2\2<\u0144\3\2\2\2>\u0147\3\2\2\2@\u014a\3\2\2\2B"+
		"\u0150\3\2\2\2D\u0153\3\2\2\2F\u015d\3\2\2\2HJ\5\4\3\2IH\3\2\2\2JK\3\2"+
		"\2\2KI\3\2\2\2KL\3\2\2\2LM\3\2\2\2MN\7\2\2\3N\3\3\2\2\2OR\5\6\4\2PR\5"+
		"\f\7\2QO\3\2\2\2QP\3\2\2\2R\5\3\2\2\2ST\5F$\2TY\5\b\5\2UV\7/\2\2VX\5\b"+
		"\5\2WU\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\\\3\2\2\2[Y\3\2\2\2\\]\7"+
		"-\2\2]\7\3\2\2\2^c\7\62\2\2_`\7+\2\2`a\5\34\17\2ab\7,\2\2bd\3\2\2\2c_"+
		"\3\2\2\2cd\3\2\2\2d\t\3\2\2\2ej\5F$\2fj\7\22\2\2gj\5\24\13\2hj\5\26\f"+
		"\2ie\3\2\2\2if\3\2\2\2ig\3\2\2\2ih\3\2\2\2j\13\3\2\2\2kl\5\16\b\2lm\7"+
		"\62\2\2mo\7\'\2\2np\5\20\t\2on\3\2\2\2op\3\2\2\2pq\3\2\2\2qr\7(\2\2rs"+
		"\5D#\2s\r\3\2\2\2tx\5\26\f\2ux\5F$\2vx\7\22\2\2wt\3\2\2\2wu\3\2\2\2wv"+
		"\3\2\2\2x\17\3\2\2\2y~\5\22\n\2z{\7/\2\2{}\5\22\n\2|z\3\2\2\2}\u0080\3"+
		"\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\21\3\2\2\2\u0080~\3\2\2\2\u0081\u0082"+
		"\5F$\2\u0082\u0087\7\62\2\2\u0083\u0084\7+\2\2\u0084\u0085\5\34\17\2\u0085"+
		"\u0086\7,\2\2\u0086\u0088\3\2\2\2\u0087\u0083\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088\23\3\2\2\2\u0089\u008a\5F$\2\u008a\u008b\7+\2\2\u008b\u008c"+
		"\7\5\2\2\u008c\u008d\7,\2\2\u008d\25\3\2\2\2\u008e\u0091\5\30\r\2\u008f"+
		"\u0091\5\32\16\2\u0090\u008e\3\2\2\2\u0090\u008f\3\2\2\2\u0091\27\3\2"+
		"\2\2\u0092\u0093\5F$\2\u0093\u0094\7\62\2\2\u0094\u0095\7+\2\2\u0095\u0096"+
		"\7,\2\2\u0096\31\3\2\2\2\u0097\u0098\5F$\2\u0098\u0099\7+\2\2\u0099\u009a"+
		"\7,\2\2\u009a\33\3\2\2\2\u009b\u009c\5\36\20\2\u009c\u009d\7&\2\2\u009d"+
		"\u009e\5\34\17\2\u009e\u00a1\3\2\2\2\u009f\u00a1\5\36\20\2\u00a0\u009b"+
		"\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1\35\3\2\2\2\u00a2\u00a3\b\20\1\2\u00a3"+
		"\u00a4\5 \21\2\u00a4\u00aa\3\2\2\2\u00a5\u00a6\f\4\2\2\u00a6\u00a7\7\36"+
		"\2\2\u00a7\u00a9\5 \21\2\u00a8\u00a5\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\37\3\2\2\2\u00ac\u00aa\3\2\2"+
		"\2\u00ad\u00ae\b\21\1\2\u00ae\u00af\5\"\22\2\u00af\u00b5\3\2\2\2\u00b0"+
		"\u00b1\f\4\2\2\u00b1\u00b2\7\37\2\2\u00b2\u00b4\5\"\22\2\u00b3\u00b0\3"+
		"\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"!\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9\5$\23\2\u00b9\u00ba\7!\2\2\u00ba"+
		"\u00bb\5$\23\2\u00bb\u00c2\3\2\2\2\u00bc\u00bd\5$\23\2\u00bd\u00be\7 "+
		"\2\2\u00be\u00bf\5$\23\2\u00bf\u00c2\3\2\2\2\u00c0\u00c2\5$\23\2\u00c1"+
		"\u00b8\3\2\2\2\u00c1\u00bc\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2#\3\2\2\2"+
		"\u00c3\u00c4\5&\24\2\u00c4\u00c5\7\"\2\2\u00c5\u00c6\5&\24\2\u00c6\u00d5"+
		"\3\2\2\2\u00c7\u00c8\5&\24\2\u00c8\u00c9\7$\2\2\u00c9\u00ca\5&\24\2\u00ca"+
		"\u00d5\3\2\2\2\u00cb\u00cc\5&\24\2\u00cc\u00cd\7#\2\2\u00cd\u00ce\5&\24"+
		"\2\u00ce\u00d5\3\2\2\2\u00cf\u00d0\5&\24\2\u00d0\u00d1\7%\2\2\u00d1\u00d2"+
		"\5&\24\2\u00d2\u00d5\3\2\2\2\u00d3\u00d5\5&\24\2\u00d4\u00c3\3\2\2\2\u00d4"+
		"\u00c7\3\2\2\2\u00d4\u00cb\3\2\2\2\u00d4\u00cf\3\2\2\2\u00d4\u00d3\3\2"+
		"\2\2\u00d5%\3\2\2\2\u00d6\u00d7\b\24\1\2\u00d7\u00d8\5(\25\2\u00d8\u00e1"+
		"\3\2\2\2\u00d9\u00da\f\5\2\2\u00da\u00db\7\30\2\2\u00db\u00e0\5(\25\2"+
		"\u00dc\u00dd\f\4\2\2\u00dd\u00de\7\31\2\2\u00de\u00e0\5(\25\2\u00df\u00d9"+
		"\3\2\2\2\u00df\u00dc\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\'\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e5\b\25\1"+
		"\2\u00e5\u00e6\5*\26\2\u00e6\u00f2\3\2\2\2\u00e7\u00e8\f\6\2\2\u00e8\u00e9"+
		"\7\33\2\2\u00e9\u00f1\5*\26\2\u00ea\u00eb\f\5\2\2\u00eb\u00ec\7\32\2\2"+
		"\u00ec\u00f1\5*\26\2\u00ed\u00ee\f\4\2\2\u00ee\u00ef\7\35\2\2\u00ef\u00f1"+
		"\5*\26\2\u00f0\u00e7\3\2\2\2\u00f0\u00ea\3\2\2\2\u00f0\u00ed\3\2\2\2\u00f1"+
		"\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3)\3\2\2\2"+
		"\u00f4\u00f2\3\2\2\2\u00f5\u00f6\t\2\2\2\u00f6\u00f9\5*\26\2\u00f7\u00f9"+
		"\5,\27\2\u00f8\u00f5\3\2\2\2\u00f8\u00f7\3\2\2\2\u00f9+\3\2\2\2\u00fa"+
		"\u00fb\5.\30\2\u00fb\u00fc\7+\2\2\u00fc\u00fd\5\34\17\2\u00fd\u00fe\7"+
		",\2\2\u00fe\u0101\3\2\2\2\u00ff\u0101\5.\30\2\u0100\u00fa\3\2\2\2\u0100"+
		"\u00ff\3\2\2\2\u0101-\3\2\2\2\u0102\u0103\7\'\2\2\u0103\u0104\5\34\17"+
		"\2\u0104\u0105\7(\2\2\u0105\u010d\3\2\2\2\u0106\u010d\7\62\2\2\u0107\u010d"+
		"\7\7\2\2\u0108\u010d\7\5\2\2\u0109\u010d\7\6\2\2\u010a\u010d\7\b\2\2\u010b"+
		"\u010d\5\60\31\2\u010c\u0102\3\2\2\2\u010c\u0106\3\2\2\2\u010c\u0107\3"+
		"\2\2\2\u010c\u0108\3\2\2\2\u010c\u0109\3\2\2\2\u010c\u010a\3\2\2\2\u010c"+
		"\u010b\3\2\2\2\u010d/\3\2\2\2\u010e\u010f\7\62\2\2\u010f\u0111\7\'\2\2"+
		"\u0110\u0112\5\62\32\2\u0111\u0110\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113"+
		"\3\2\2\2\u0113\u0114\7(\2\2\u0114\61\3\2\2\2\u0115\u011a\5\34\17\2\u0116"+
		"\u0117\7/\2\2\u0117\u0119\5\34\17\2\u0118\u0116\3\2\2\2\u0119\u011c\3"+
		"\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\63\3\2\2\2\u011c"+
		"\u011a\3\2\2\2\u011d\u0126\5\66\34\2\u011e\u0126\5:\36\2\u011f\u0126\5"+
		"8\35\2\u0120\u0126\5<\37\2\u0121\u0126\5> \2\u0122\u0126\5@!\2\u0123\u0126"+
		"\5D#\2\u0124\u0126\5B\"\2\u0125\u011d\3\2\2\2\u0125\u011e\3\2\2\2\u0125"+
		"\u011f\3\2\2\2\u0125\u0120\3\2\2\2\u0125\u0121\3\2\2\2\u0125\u0122\3\2"+
		"\2\2\u0125\u0123\3\2\2\2\u0125\u0124\3\2\2\2\u0126\65\3\2\2\2\u0127\u0128"+
		"\7\17\2\2\u0128\u0129\7\'\2\2\u0129\u012a\5\34\17\2\u012a\u012b\7(\2\2"+
		"\u012b\u012e\5\64\33\2\u012c\u012d\7\f\2\2\u012d\u012f\5\64\33\2\u012e"+
		"\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\67\3\2\2\2\u0130\u0132\7\23\2"+
		"\2\u0131\u0133\5\64\33\2\u0132\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134"+
		"\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0137\7\24"+
		"\2\2\u0137\u0138\5\34\17\2\u0138\u0139\7-\2\2\u01399\3\2\2\2\u013a\u013b"+
		"\7\r\2\2\u013b\u013c\7\'\2\2\u013c\u013d\5\34\17\2\u013d\u013e\7-\2\2"+
		"\u013e\u013f\5\34\17\2\u013f\u0140\7-\2\2\u0140\u0141\5\34\17\2\u0141"+
		"\u0142\7(\2\2\u0142\u0143\5\64\33\2\u0143;\3\2\2\2\u0144\u0145\7\n\2\2"+
		"\u0145\u0146\7-\2\2\u0146=\3\2\2\2\u0147\u0148\7\13\2\2\u0148\u0149\7"+
		"-\2\2\u0149?\3\2\2\2\u014a\u014c\7\21\2\2\u014b\u014d\5\34\17\2\u014c"+
		"\u014b\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014f\7-"+
		"\2\2\u014fA\3\2\2\2\u0150\u0151\5\34\17\2\u0151\u0152\7-\2\2\u0152C\3"+
		"\2\2\2\u0153\u0158\7)\2\2\u0154\u0157\5\6\4\2\u0155\u0157\5\64\33\2\u0156"+
		"\u0154\3\2\2\2\u0156\u0155\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2"+
		"\2\2\u0158\u0159\3\2\2\2\u0159\u015b\3\2\2\2\u015a\u0158\3\2\2\2\u015b"+
		"\u015c\7*\2\2\u015cE\3\2\2\2\u015d\u015e\t\3\2\2\u015eG\3\2\2\2 KQYci"+
		"ow~\u0087\u0090\u00a0\u00aa\u00b5\u00c1\u00d4\u00df\u00e1\u00f0\u00f2"+
		"\u00f8\u0100\u010c\u0111\u011a\u0125\u012e\u0134\u014c\u0156\u0158";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}