
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class modulus_expression
{

	@Element
	private String kw_mod = "mod";

	@Element
	private numeric_value_expression_dividend numeric_value_expression_dividend = new numeric_value_expression_dividend( );

	@Element
	private numeric_value_expression_divisor numeric_value_expression_divisor = new numeric_value_expression_divisor( );

	public numeric_value_expression_dividend getNumeric_value_expression_dividend( )
	{
		return numeric_value_expression_dividend;
	}

	public numeric_value_expression_divisor getNumeric_value_expression_divisor( )
	{
		return numeric_value_expression_divisor;
	}

}
