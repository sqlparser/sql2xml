
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class power_function
{

	@Element
	private String kw_power = "power";

	@Element
	private numeric_value_expression_base numeric_value_expression_base = new numeric_value_expression_base( );

	@Element
	private numeric_value_expression_exponent numeric_value_expression_exponent = new numeric_value_expression_exponent( );

	public numeric_value_expression_base getNumeric_value_expression_base( )
	{
		return numeric_value_expression_base;
	}

	public numeric_value_expression_exponent getNumeric_value_expression_exponent( )
	{
		return numeric_value_expression_exponent;
	}

}
