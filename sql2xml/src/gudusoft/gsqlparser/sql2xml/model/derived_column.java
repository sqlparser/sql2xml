
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class derived_column
{

	@Element
	private value_expression value_expression = new value_expression( );

	@Element(required = false)
	private as_clause as_clause;

	public as_clause getAs_clause( )
	{
		return as_clause;
	}

	public void setAs_clause( as_clause as_clause )
	{
		this.as_clause = as_clause;
	}

	public value_expression getValue_expression( )
	{
		return value_expression;
	}

}
