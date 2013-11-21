
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class boolean_term
{

	@Element(required = false)
	private boolean_factor boolean_factor;

	@Element(required = false)
	private boolean_value_expression_and boolean_value_expression_and;

	public boolean_factor getBoolean_factor( )
	{
		return boolean_factor;
	}

	public void setBoolean_factor( boolean_factor boolean_factor )
	{
		this.boolean_factor = boolean_factor;
	}

	public boolean_value_expression_and getBoolean_value_expression_and( )
	{
		return boolean_value_expression_and;
	}

	public void setBoolean_value_expression_and(
			boolean_value_expression_and boolean_value_expression_and )
	{
		this.boolean_value_expression_and = boolean_value_expression_and;
	}

}
