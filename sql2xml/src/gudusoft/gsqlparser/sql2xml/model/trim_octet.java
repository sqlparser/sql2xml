
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class trim_octet
{

	@Element
	private binary_value_expression binary_value_expression = new binary_value_expression( );

	public binary_value_expression getBinary_value_expression( )
	{
		return binary_value_expression;
	}

}
