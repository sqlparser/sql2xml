
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class binary_concatenation
{

	@Element
	private binary_value_expression binary_value_expression = new binary_value_expression( );

	@Element
	private String concatenation_operator = "||";

	@Element
	private binary_factor binary_factor = new binary_factor( );

	public binary_value_expression getBinary_value_expression( )
	{
		return binary_value_expression;
	}

	public binary_factor getBinary_factor( )
	{
		return binary_factor;
	}

}
