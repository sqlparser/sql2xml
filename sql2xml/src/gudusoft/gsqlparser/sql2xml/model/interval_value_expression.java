
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class interval_value_expression
{

	@Element(required = false)
	private interval_term interval_term;

	@Element(required = false)
	private interval_value_expression_plus_interval_term interval_value_expression_plus_interval_term;

	@Element(required = false)
	private interval_value_expression_minus_interval_term interval_value_expression_minus_interval_term;

	@Element(required = false)
	private datetime_value_expression_minus_datetime_term datetime_value_expression_minus_datetime_term;

	public interval_term getInterval_term( )
	{
		return interval_term;
	}

	public void setInterval_term( interval_term interval_term )
	{
		this.interval_term = interval_term;
	}

	public interval_value_expression_plus_interval_term getInterval_value_expression_plus_interval_term( )
	{
		return interval_value_expression_plus_interval_term;
	}

	public void setInterval_value_expression_plus_interval_term(
			interval_value_expression_plus_interval_term interval_value_expression_plus_interval_term )
	{
		this.interval_value_expression_plus_interval_term = interval_value_expression_plus_interval_term;
	}

	public interval_value_expression_minus_interval_term getInterval_value_expression_minus_interval_term( )
	{
		return interval_value_expression_minus_interval_term;
	}

	public void setInterval_value_expression_minus_interval_term(
			interval_value_expression_minus_interval_term interval_value_expression_minus_interval_term )
	{
		this.interval_value_expression_minus_interval_term = interval_value_expression_minus_interval_term;
	}

	public datetime_value_expression_minus_datetime_term getDatetime_value_expression_minus_datetime_term( )
	{
		return datetime_value_expression_minus_datetime_term;
	}

	public void setDatetime_value_expression_minus_datetime_term(
			datetime_value_expression_minus_datetime_term datetime_value_expression_minus_datetime_term )
	{
		this.datetime_value_expression_minus_datetime_term = datetime_value_expression_minus_datetime_term;
	}

}
