
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class end_field
{

	@Element(required = false)
	protected non_second_primary_datetime_field non_second_primary_datetime_field;

	@Element(required = false)
	protected second_interval_fractional_seconds_precision second_interval_fractional_seconds_precision;

	public non_second_primary_datetime_field getNon_second_primary_datetime_field( )
	{
		return non_second_primary_datetime_field;
	}

	public void setNon_second_primary_datetime_field(
			non_second_primary_datetime_field non_second_primary_datetime_field )
	{
		this.non_second_primary_datetime_field = non_second_primary_datetime_field;
	}

	public second_interval_fractional_seconds_precision getSecond_interval_fractional_seconds_precision( )
	{
		return second_interval_fractional_seconds_precision;
	}

	public void setSecond_interval_fractional_seconds_precision(
			second_interval_fractional_seconds_precision second_interval_fractional_seconds_precision )
	{
		this.second_interval_fractional_seconds_precision = second_interval_fractional_seconds_precision;
	}

}
