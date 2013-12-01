
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class binary_primary
{

	@Element(required = false)
	private value_expression_primary value_expression_primary;

	@Element(required = false)
	private string_value_function string_value_function;

	public value_expression_primary getValue_expression_primary( )
	{
		return value_expression_primary;
	}

	public void setValue_expression_primary(
			value_expression_primary value_expression_primary )
	{
		this.value_expression_primary = value_expression_primary;
	}

	public string_value_function getString_value_function( )
	{
		return string_value_function;
	}

	public void setString_value_function(
			string_value_function string_value_function )
	{
		this.string_value_function = string_value_function;
	}

}
