
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class boolean_value_expression
{

	@Element(required = false)
	private boolean_term boolean_term;

	@Element(required = false)
	private boolean_value_expression_or boolean_value_expression_or;

	public boolean_term getBoolean_term( )
	{
		return boolean_term;
	}

	public void setBoolean_term( boolean_term boolean_term )
	{
		this.boolean_term = boolean_term;
	}

	public boolean_value_expression_or getBoolean_value_expression_or( )
	{
		return boolean_value_expression_or;
	}

	public void setBoolean_value_expression_or(
			boolean_value_expression_or boolean_value_expression_or )
	{
		this.boolean_value_expression_or = boolean_value_expression_or;
	}

}
