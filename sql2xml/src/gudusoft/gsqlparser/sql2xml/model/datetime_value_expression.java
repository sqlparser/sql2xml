
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class datetime_value_expression
{

	@Element(required = false)
	private datetime_term datetime_term;

	@Element(required = false)
	private interval_value_expression_plus_datetime_term interval_value_expression_plus_datetime_term;

	@Element(required = false)
	private datetime_value_expression_plus_interval_term datetime_value_expression_plus_interval_term;

	@Element(required = false)
	private datetime_value_expression_minus_interval_term datetime_value_expression_minus_interval_term;

	public datetime_term getDatetime_term( )
	{
		return datetime_term;
	}

	public void setDatetime_term( datetime_term datetime_term )
	{
		this.datetime_term = datetime_term;
	}

	public interval_value_expression_plus_datetime_term getInterval_value_expression_plus_datetime_term( )
	{
		return interval_value_expression_plus_datetime_term;
	}

	public void setInterval_value_expression_plus_datetime_term(
			interval_value_expression_plus_datetime_term interval_value_expression_plus_datetime_term )
	{
		this.interval_value_expression_plus_datetime_term = interval_value_expression_plus_datetime_term;
	}

	public datetime_value_expression_plus_interval_term getDatetime_value_expression_plus_interval_term( )
	{
		return datetime_value_expression_plus_interval_term;
	}

	public void setDatetime_value_expression_plus_interval_term(
			datetime_value_expression_plus_interval_term datetime_value_expression_plus_interval_term )
	{
		this.datetime_value_expression_plus_interval_term = datetime_value_expression_plus_interval_term;
	}

	public datetime_value_expression_minus_interval_term getDatetime_value_expression_minus_interval_term( )
	{
		return datetime_value_expression_minus_interval_term;
	}

	public void setDatetime_value_expression_minus_interval_term(
			datetime_value_expression_minus_interval_term datetime_value_expression_minus_interval_term )
	{
		this.datetime_value_expression_minus_interval_term = datetime_value_expression_minus_interval_term;
	}

}
