
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class parenthesized_value_expression
{

	@Element
	private value_expression value_expression = new value_expression( );

	public value_expression getValue_expression( )
	{
		return value_expression;
	}

}
