
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class second_interval_fractional_seconds_precision
{

	@Element
	private String kw_second = "second";

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

}
