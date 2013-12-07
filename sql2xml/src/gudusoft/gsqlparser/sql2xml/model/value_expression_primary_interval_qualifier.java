
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class value_expression_primary_interval_qualifier
{

	@Element
	private value_expression_primary value_expression_primary = new value_expression_primary( );

	@Element(required = false)
	private interval_qualifier interval_qualifier;

	public interval_qualifier getInterval_qualifier( )
	{
		return interval_qualifier;
	}

	public void setInterval_qualifier( interval_qualifier interval_qualifier )
	{
		this.interval_qualifier = interval_qualifier;
	}

	public value_expression_primary getValue_expression_primary( )
	{
		return value_expression_primary;
	}

}
