
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class boolean_predicand
{

	@Element(required = false)
	private parenthesized_boolean_value_expression parenthesized_boolean_value_expression;

	@Element(required = false)
	private nonparenthesized_value_expression_primary nonparenthesized_value_expression_primary;

	public parenthesized_boolean_value_expression getParenthesized_boolean_value_expression( )
	{
		return parenthesized_boolean_value_expression;
	}

	public void setParenthesized_boolean_value_expression(
			parenthesized_boolean_value_expression parenthesized_boolean_value_expression )
	{
		this.parenthesized_boolean_value_expression = parenthesized_boolean_value_expression;
	}

	public nonparenthesized_value_expression_primary getNonparenthesized_value_expression_primary( )
	{
		return nonparenthesized_value_expression_primary;
	}

	public void setNonparenthesized_value_expression_primary(
			nonparenthesized_value_expression_primary nonparenthesized_value_expression_primary )
	{
		this.nonparenthesized_value_expression_primary = nonparenthesized_value_expression_primary;
	}

}
