
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class natural_logarithm
{

	@Element
	private String kw_ln = "ln";

	@Element
	private numeric_value_expression numeric_value_expression = new numeric_value_expression( );

	public numeric_value_expression getNumeric_value_expression( )
	{
		return numeric_value_expression;
	}

}
