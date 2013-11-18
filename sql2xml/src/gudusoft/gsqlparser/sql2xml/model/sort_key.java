
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class sort_key
{

	@Element
	private value_expression value_expression;

	public value_expression getValue_expression( )
	{
		return value_expression;
	}

	public void setValue_expression( value_expression value_expression )
	{
		this.value_expression = value_expression;
	}
}
