
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class boolean_value_expression_and
{

	@Element
	private boolean_term boolean_term = new boolean_term( );

	@Element
	private boolean_factor boolean_factor = new boolean_factor( );

	public boolean_term getBoolean_term( )
	{
		return boolean_term;
	}

	public boolean_factor getBoolean_factor( )
	{
		return boolean_factor;
	}

}
