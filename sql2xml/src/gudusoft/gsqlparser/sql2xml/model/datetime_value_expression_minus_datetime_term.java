
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class datetime_value_expression_minus_datetime_term
{

	@Element
	private datetime_value_expression datetime_value_expression = new datetime_value_expression( );

	@Element
	private datetime_term datetime_term = new datetime_term( );

	@Element
	private interval_qualifier interval_qualifier = new interval_qualifier( );

	public datetime_value_expression getDatetime_value_expression( )
	{
		return datetime_value_expression;
	}

	public datetime_term getDatetime_term( )
	{
		return datetime_term;
	}

	public interval_qualifier getInterval_qualifier( )
	{
		return interval_qualifier;
	}

}
