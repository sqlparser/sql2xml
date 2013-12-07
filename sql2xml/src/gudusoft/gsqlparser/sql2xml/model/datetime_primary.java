
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class datetime_primary
{

	@Element(required = false)
	private value_expression_primary value_expression_primary;

	@Element(required = false)
	private datetime_value_function datetime_value_function;

	public value_expression_primary getValue_expression_primary( )
	{
		return value_expression_primary;
	}

	public void setValue_expression_primary(
			value_expression_primary value_expression_primary )
	{
		this.value_expression_primary = value_expression_primary;
	}

	public datetime_value_function getDatetime_value_function( )
	{
		return datetime_value_function;
	}

	public void setDatetime_value_function(
			datetime_value_function datetime_value_function )
	{
		this.datetime_value_function = datetime_value_function;
	}

}
