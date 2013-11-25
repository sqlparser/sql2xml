
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class plus
{

	@Element
	private numeric_value_expression numeric_value_expression = new numeric_value_expression( );

	@Element
	private term term = new term( );

	public numeric_value_expression getNumeric_value_expression( )
	{
		return numeric_value_expression;
	}

	public term getTerm( )
	{
		return term;
	}

}
