// Generated from E:/cao hoc/nlnnlt/NL2018/ASS2/initial2/src/main/mc/parser\MC.g4 by ANTLR 4.7
package mc.parser;

	package mc.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MCParser}.
 */
public interface MCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MCParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MCParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MCParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#one_decl}.
	 * @param ctx the parse tree
	 */
	void enterOne_decl(MCParser.One_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#one_decl}.
	 * @param ctx the parse tree
	 */
	void exitOne_decl(MCParser.One_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(MCParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(MCParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(MCParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(MCParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MCParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MCParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void enterFunc_decl(MCParser.Func_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void exitFunc_decl(MCParser.Func_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#function_type}.
	 * @param ctx the parse tree
	 */
	void enterFunction_type(MCParser.Function_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#function_type}.
	 * @param ctx the parse tree
	 */
	void exitFunction_type(MCParser.Function_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#list_parameter_decl}.
	 * @param ctx the parse tree
	 */
	void enterList_parameter_decl(MCParser.List_parameter_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#list_parameter_decl}.
	 * @param ctx the parse tree
	 */
	void exitList_parameter_decl(MCParser.List_parameter_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#parameter_decl}.
	 * @param ctx the parse tree
	 */
	void enterParameter_decl(MCParser.Parameter_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#parameter_decl}.
	 * @param ctx the parse tree
	 */
	void exitParameter_decl(MCParser.Parameter_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#array_type}.
	 * @param ctx the parse tree
	 */
	void enterArray_type(MCParser.Array_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#array_type}.
	 * @param ctx the parse tree
	 */
	void exitArray_type(MCParser.Array_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#array_pointer_type}.
	 * @param ctx the parse tree
	 */
	void enterArray_pointer_type(MCParser.Array_pointer_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#array_pointer_type}.
	 * @param ctx the parse tree
	 */
	void exitArray_pointer_type(MCParser.Array_pointer_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#input_param_pointer}.
	 * @param ctx the parse tree
	 */
	void enterInput_param_pointer(MCParser.Input_param_pointerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#input_param_pointer}.
	 * @param ctx the parse tree
	 */
	void exitInput_param_pointer(MCParser.Input_param_pointerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#output_param_pointer}.
	 * @param ctx the parse tree
	 */
	void enterOutput_param_pointer(MCParser.Output_param_pointerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#output_param_pointer}.
	 * @param ctx the parse tree
	 */
	void exitOutput_param_pointer(MCParser.Output_param_pointerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MCParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MCParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#term1}.
	 * @param ctx the parse tree
	 */
	void enterTerm1(MCParser.Term1Context ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#term1}.
	 * @param ctx the parse tree
	 */
	void exitTerm1(MCParser.Term1Context ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#term2}.
	 * @param ctx the parse tree
	 */
	void enterTerm2(MCParser.Term2Context ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#term2}.
	 * @param ctx the parse tree
	 */
	void exitTerm2(MCParser.Term2Context ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#term3}.
	 * @param ctx the parse tree
	 */
	void enterTerm3(MCParser.Term3Context ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#term3}.
	 * @param ctx the parse tree
	 */
	void exitTerm3(MCParser.Term3Context ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#term4}.
	 * @param ctx the parse tree
	 */
	void enterTerm4(MCParser.Term4Context ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#term4}.
	 * @param ctx the parse tree
	 */
	void exitTerm4(MCParser.Term4Context ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#term5}.
	 * @param ctx the parse tree
	 */
	void enterTerm5(MCParser.Term5Context ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#term5}.
	 * @param ctx the parse tree
	 */
	void exitTerm5(MCParser.Term5Context ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#term6}.
	 * @param ctx the parse tree
	 */
	void enterTerm6(MCParser.Term6Context ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#term6}.
	 * @param ctx the parse tree
	 */
	void exitTerm6(MCParser.Term6Context ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#term7}.
	 * @param ctx the parse tree
	 */
	void enterTerm7(MCParser.Term7Context ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#term7}.
	 * @param ctx the parse tree
	 */
	void exitTerm7(MCParser.Term7Context ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#term8}.
	 * @param ctx the parse tree
	 */
	void enterTerm8(MCParser.Term8Context ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#term8}.
	 * @param ctx the parse tree
	 */
	void exitTerm8(MCParser.Term8Context ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#term9}.
	 * @param ctx the parse tree
	 */
	void enterTerm9(MCParser.Term9Context ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#term9}.
	 * @param ctx the parse tree
	 */
	void exitTerm9(MCParser.Term9Context ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(MCParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(MCParser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list(MCParser.Expr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list(MCParser.Expr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MCParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MCParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(MCParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(MCParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#do_statement}.
	 * @param ctx the parse tree
	 */
	void enterDo_statement(MCParser.Do_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#do_statement}.
	 * @param ctx the parse tree
	 */
	void exitDo_statement(MCParser.Do_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_statement(MCParser.For_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_statement(MCParser.For_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#break_statement}.
	 * @param ctx the parse tree
	 */
	void enterBreak_statement(MCParser.Break_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#break_statement}.
	 * @param ctx the parse tree
	 */
	void exitBreak_statement(MCParser.Break_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#continue_statement}.
	 * @param ctx the parse tree
	 */
	void enterContinue_statement(MCParser.Continue_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#continue_statement}.
	 * @param ctx the parse tree
	 */
	void exitContinue_statement(MCParser.Continue_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void enterReturn_statement(MCParser.Return_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void exitReturn_statement(MCParser.Return_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#expr_statement}.
	 * @param ctx the parse tree
	 */
	void enterExpr_statement(MCParser.Expr_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#expr_statement}.
	 * @param ctx the parse tree
	 */
	void exitExpr_statement(MCParser.Expr_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void enterBlock_statement(MCParser.Block_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void exitBlock_statement(MCParser.Block_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MCParser#primitivetype}.
	 * @param ctx the parse tree
	 */
	void enterPrimitivetype(MCParser.PrimitivetypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MCParser#primitivetype}.
	 * @param ctx the parse tree
	 */
	void exitPrimitivetype(MCParser.PrimitivetypeContext ctx);
}