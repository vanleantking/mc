// Generated from src/main/mc/parser/MC.g4 by ANTLR 4.6

	package mc.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MCParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MCVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MCParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MCParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#one_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOne_decl(MCParser.One_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#var_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_decl(MCParser.Var_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(MCParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MCParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#func_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_decl(MCParser.Func_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#function_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_type(MCParser.Function_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#list_parameter_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_parameter_decl(MCParser.List_parameter_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#parameter_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_decl(MCParser.Parameter_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#array_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_type(MCParser.Array_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#array_pointer_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_pointer_type(MCParser.Array_pointer_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#input_param_pointer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput_param_pointer(MCParser.Input_param_pointerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#output_param_pointer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput_param_pointer(MCParser.Output_param_pointerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(MCParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#term1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm1(MCParser.Term1Context ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#term2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm2(MCParser.Term2Context ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#term3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm3(MCParser.Term3Context ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#term4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm4(MCParser.Term4Context ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#term5}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm5(MCParser.Term5Context ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#term6}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm6(MCParser.Term6Context ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#term7}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm7(MCParser.Term7Context ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#term8}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm8(MCParser.Term8Context ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#term9}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm9(MCParser.Term9Context ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(MCParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#expr_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_list(MCParser.Expr_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MCParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(MCParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#do_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDo_statement(MCParser.Do_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#for_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_statement(MCParser.For_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#break_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak_statement(MCParser.Break_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#continue_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinue_statement(MCParser.Continue_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#return_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_statement(MCParser.Return_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#expr_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_statement(MCParser.Expr_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#block_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_statement(MCParser.Block_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MCParser#primitivetype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitivetype(MCParser.PrimitivetypeContext ctx);
}