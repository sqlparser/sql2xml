
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class value_expression_primary
{

	@Element(required = false)
	private parenthesized_value_expression parenthesized_value_expression;

	@Element(required = false)
	private nonparenthesized_value_expression_primary nonparenthesized_value_expression_primary;

	public parenthesized_value_expression getParenthesized_value_expression( )
	{
		return parenthesized_value_expression;
	}

	public void setParenthesized_value_expression(
			parenthesized_value_expression parenthesized_value_expression )
	{
		this.parenthesized_value_expression = parenthesized_value_expression;
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
