
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class interval_leading_field_precision_comma
{

	@Element
	private interval_leading_field_precision interval_leading_field_precision = new interval_leading_field_precision( );

	@Element(required = false)
	private interval_fractional_seconds_precision interval_fractional_seconds_precision;

	public interval_fractional_seconds_precision getInterval_fractional_seconds_precision( )
	{
		return interval_fractional_seconds_precision;
	}

	public void setInterval_fractional_seconds_precision(
			interval_fractional_seconds_precision interval_fractional_seconds_precision )
	{
		this.interval_fractional_seconds_precision = interval_fractional_seconds_precision;
	}

	public interval_leading_field_precision getInterval_leading_field_precision( )
	{
		return interval_leading_field_precision;
	}

}
