
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class interval_primary
{

	@Element(required = false)
	private value_expression_primary_interval_qualifier value_expression_primary_interval_qualifier;

	@Element(required = false)
	private interval_value_function interval_value_function;

	public value_expression_primary_interval_qualifier getValue_expression_primary_interval_qualifier( )
	{
		return value_expression_primary_interval_qualifier;
	}

	public void setValue_expression_primary_interval_qualifier(
			value_expression_primary_interval_qualifier value_expression_primary_interval_qualifier )
	{
		this.value_expression_primary_interval_qualifier = value_expression_primary_interval_qualifier;
	}

	public interval_value_function getInterval_value_function( )
	{
		return interval_value_function;
	}

	public void setInterval_value_function(
			interval_value_function interval_value_function )
	{
		this.interval_value_function = interval_value_function;
	}

}
