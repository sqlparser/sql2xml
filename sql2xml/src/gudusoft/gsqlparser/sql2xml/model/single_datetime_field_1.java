
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class single_datetime_field_1
{

	@Element
	protected non_second_primary_datetime_field non_second_primary_datetime_field = new non_second_primary_datetime_field( );

	@Element(required = false)
	protected interval_leading_field_precision interval_leading_field_precision;

	public interval_leading_field_precision getInterval_leading_field_precision( )
	{
		return interval_leading_field_precision;
	}

	public void setInterval_leading_field_precision(
			interval_leading_field_precision interval_leading_field_precision )
	{
		this.interval_leading_field_precision = interval_leading_field_precision;
	}

	public non_second_primary_datetime_field getNon_second_primary_datetime_field( )
	{
		return non_second_primary_datetime_field;
	}

}
