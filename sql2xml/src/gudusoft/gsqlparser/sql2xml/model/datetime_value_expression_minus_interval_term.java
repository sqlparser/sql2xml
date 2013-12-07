
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class datetime_value_expression_minus_interval_term
{

	@Element
	private datetime_value_expression datetime_value_expression = new datetime_value_expression( );

	@Element
	private interval_term interval_term = new interval_term( );

	public datetime_value_expression getDatetime_value_expression( )
	{
		return datetime_value_expression;
	}

	public interval_term getInterval_term( )
	{
		return interval_term;
	}

}
