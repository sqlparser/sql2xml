
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class boolean_value_expression_or
{

	@Element
	private boolean_value_expression boolean_value_expression = new boolean_value_expression( );

	@Element
	private boolean_term boolean_term = new boolean_term( );

	public boolean_value_expression getBoolean_value_expression( )
	{
		return boolean_value_expression;
	}

	public boolean_term getBoolean_term( )
	{
		return boolean_term;
	}

}
