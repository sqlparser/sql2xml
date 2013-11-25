
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class ceiling_function
{

	@Element
	private kw_ceil_ceiling kw_ceil_ceiling = new kw_ceil_ceiling( );

	@Element
	private numeric_value_expression numeric_value_expression = new numeric_value_expression( );

	public kw_ceil_ceiling getKw_ceil_ceiling( )
	{
		return kw_ceil_ceiling;
	}

	public numeric_value_expression getNumeric_value_expression( )
	{
		return numeric_value_expression;
	}
}
