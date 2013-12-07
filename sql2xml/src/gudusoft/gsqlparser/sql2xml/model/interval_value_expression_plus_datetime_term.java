
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class interval_value_expression_plus_datetime_term
{

	@Element
	private interval_value_expression interval_value_expression = new interval_value_expression( );

	@Element
	private datetime_term datetime_term = new datetime_term( );

	public interval_value_expression getInterval_value_expression( )
	{
		return interval_value_expression;
	}

	public datetime_term getDatetime_term( )
	{
		return datetime_term;
	}

}
