
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class numeric_primary
{

	@Element(required = false)
	private value_expression_primary value_expression_primary;

	@Element(required = false)
	private numeric_value_function numeric_value_function;

	public value_expression_primary getValue_expression_primary( )
	{
		return value_expression_primary;
	}

	public void setValue_expression_primary(
			value_expression_primary value_expression_primary )
	{
		this.value_expression_primary = value_expression_primary;
	}

	public numeric_value_function getNumeric_value_function( )
	{
		return numeric_value_function;
	}

	public void setNumeric_value_function(
			numeric_value_function numeric_value_function )
	{
		this.numeric_value_function = numeric_value_function;
	}

}
