// Generated from simpleCalc.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link simpleCalcParser}.
 */
public interface simpleCalcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link simpleCalcParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(simpleCalcParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleCalcParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(simpleCalcParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleCalcParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(simpleCalcParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleCalcParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(simpleCalcParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStatment}
	 * labeled alternative in {@link simpleCalcParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStatment(simpleCalcParser.IfStatmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStatment}
	 * labeled alternative in {@link simpleCalcParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStatment(simpleCalcParser.IfStatmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStatment}
	 * labeled alternative in {@link simpleCalcParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatment(simpleCalcParser.WhileStatmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStatment}
	 * labeled alternative in {@link simpleCalcParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatment(simpleCalcParser.WhileStatmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link simpleCalcParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterComparison(simpleCalcParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link simpleCalcParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitComparison(simpleCalcParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogOp}
	 * labeled alternative in {@link simpleCalcParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterLogOp(simpleCalcParser.LogOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogOp}
	 * labeled alternative in {@link simpleCalcParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitLogOp(simpleCalcParser.LogOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link simpleCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(simpleCalcParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link simpleCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(simpleCalcParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link simpleCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEquals(simpleCalcParser.EqualsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link simpleCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEquals(simpleCalcParser.EqualsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link simpleCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariable(simpleCalcParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link simpleCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariable(simpleCalcParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link simpleCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstant(simpleCalcParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link simpleCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstant(simpleCalcParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignVar}
	 * labeled alternative in {@link simpleCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssignVar(simpleCalcParser.AssignVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignVar}
	 * labeled alternative in {@link simpleCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssignVar(simpleCalcParser.AssignVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Calculate}
	 * labeled alternative in {@link simpleCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCalculate(simpleCalcParser.CalculateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Calculate}
	 * labeled alternative in {@link simpleCalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCalculate(simpleCalcParser.CalculateContext ctx);
}