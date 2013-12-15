
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class single_datetime_field_2
{

	@Element
	private String kw_second = "second";

	@Element(required = false)
	private interval_leading_field_precision_comma interval_leading_field_precision_comma;

	public interval_leading_field_precision_comma getInterval_leading_field_precision_comma( )
	{
		return interval_leading_field_precision_comma;
	}

	public void setInterval_leading_field_precision_comma(
			interval_leading_field_precision_comma interval_leading_field_precision_comma )
	{
		this.interval_leading_field_precision_comma = interval_leading_field_precision_comma;
	}

}
