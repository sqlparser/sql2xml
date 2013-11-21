
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class search_condition
{

	@Element
	private boolean_value_expression boolean_value_expression = new boolean_value_expression( );

	public boolean_value_expression getBoolean_value_expression( )
	{
		return boolean_value_expression;
	}

}
