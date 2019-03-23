// Generated from RuleSet.g4 by ANTLR 4.7.2

package reguly.antlr;


import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RuleSetParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RuleSetVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RuleSetParser#rule_set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule_set(RuleSetParser.Rule_setContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleSetParser#single_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_rule(RuleSetParser.Single_ruleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalExpressionAnd}
	 * labeled alternative in {@link RuleSetParser#logical_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpressionAnd(RuleSetParser.LogicalExpressionAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalExpressionNot}
	 * labeled alternative in {@link RuleSetParser#logical_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpressionNot(RuleSetParser.LogicalExpressionNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalExpressionOr}
	 * labeled alternative in {@link RuleSetParser#logical_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpressionOr(RuleSetParser.LogicalExpressionOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SpecificationExpression}
	 * labeled alternative in {@link RuleSetParser#logical_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecificationExpression(RuleSetParser.SpecificationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TotalledNumericGreaterThanComparisonSpecificationExpression}
	 * labeled alternative in {@link RuleSetParser#specification_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTotalledNumericGreaterThanComparisonSpecificationExpression(RuleSetParser.TotalledNumericGreaterThanComparisonSpecificationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumericGreaterThanComparisonSpecificationExpression}
	 * labeled alternative in {@link RuleSetParser#specification_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericGreaterThanComparisonSpecificationExpression(RuleSetParser.NumericGreaterThanComparisonSpecificationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TotalledNumericLessThanComparisonSpecificationExpression}
	 * labeled alternative in {@link RuleSetParser#specification_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTotalledNumericLessThanComparisonSpecificationExpression(RuleSetParser.TotalledNumericLessThanComparisonSpecificationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumericLessThanComparisonSpecificationExpression}
	 * labeled alternative in {@link RuleSetParser#specification_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericLessThanComparisonSpecificationExpression(RuleSetParser.NumericLessThanComparisonSpecificationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringEqualsComparisonSpecificationExpression}
	 * labeled alternative in {@link RuleSetParser#specification_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringEqualsComparisonSpecificationExpression(RuleSetParser.StringEqualsComparisonSpecificationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringContainsComparisonSpecificationExpression}
	 * labeled alternative in {@link RuleSetParser#specification_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringContainsComparisonSpecificationExpression(RuleSetParser.StringContainsComparisonSpecificationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanIsTrueComparisonSpecificationExpression}
	 * labeled alternative in {@link RuleSetParser#specification_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanIsTrueComparisonSpecificationExpression(RuleSetParser.BooleanIsTrueComparisonSpecificationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanIsFalseComparisonSpecificationExpression}
	 * labeled alternative in {@link RuleSetParser#specification_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanIsFalseComparisonSpecificationExpression(RuleSetParser.BooleanIsFalseComparisonSpecificationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayIncludesOneComparisonSpecificationExpression}
	 * labeled alternative in {@link RuleSetParser#specification_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayIncludesOneComparisonSpecificationExpression(RuleSetParser.ArrayIncludesOneComparisonSpecificationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleSetParser#left_arithmetic_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeft_arithmetic_expr(RuleSetParser.Left_arithmetic_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleSetParser#right_arithmetic_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRight_arithmetic_expr(RuleSetParser.Right_arithmetic_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticExpressionMult}
	 * labeled alternative in {@link RuleSetParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExpressionMult(RuleSetParser.ArithmeticExpressionMultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticExpressionMinus}
	 * labeled alternative in {@link RuleSetParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExpressionMinus(RuleSetParser.ArithmeticExpressionMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticExpressionNumericEntity}
	 * labeled alternative in {@link RuleSetParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExpressionNumericEntity(RuleSetParser.ArithmeticExpressionNumericEntityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticExpressionDiv}
	 * labeled alternative in {@link RuleSetParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExpressionDiv(RuleSetParser.ArithmeticExpressionDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticExpressionPlus}
	 * labeled alternative in {@link RuleSetParser#arithmetic_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExpressionPlus(RuleSetParser.ArithmeticExpressionPlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TotalledJsonPathExpression}
	 * labeled alternative in {@link RuleSetParser#numeric_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTotalledJsonPathExpression(RuleSetParser.TotalledJsonPathExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JsonPathExpression}
	 * labeled alternative in {@link RuleSetParser#numeric_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonPathExpression(RuleSetParser.JsonPathExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumericConstant}
	 * labeled alternative in {@link RuleSetParser#numeric_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericConstant(RuleSetParser.NumericConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleSetParser#value_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_expr(RuleSetParser.Value_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleSetParser#total_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTotal_expr(RuleSetParser.Total_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleSetParser#jsonpath_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonpath_expr(RuleSetParser.Jsonpath_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleSetParser#jsonpath_dotnotation_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsonpath_dotnotation_expr(RuleSetParser.Jsonpath_dotnotation_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleSetParser#dotnotation_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotnotation_expr(RuleSetParser.Dotnotation_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleSetParser#identifierWithQualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierWithQualifier(RuleSetParser.IdentifierWithQualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleSetParser#query_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery_expr(RuleSetParser.Query_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleSetParser#string_comparison_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_comparison_value(RuleSetParser.String_comparison_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleSetParser#string_array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_array(RuleSetParser.String_arrayContext ctx);
}