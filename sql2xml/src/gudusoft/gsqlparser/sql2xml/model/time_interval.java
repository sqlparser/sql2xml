
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class time_interval
{

	@Element(required = false)
	private hours_minutes_seconds_value hours_minutes_seconds_value;

	@Element(required = false)
	private minutes_seconds_value minutes_seconds_value;

	@Element(required = false)
	private seconds_value seconds_value;

	public hours_minutes_seconds_value getHours_minutes_seconds_value( )
	{
		return hours_minutes_seconds_value;
	}

	public void setHours_minutes_seconds_value(
			hours_minutes_seconds_value hours_minutes_seconds_value )
	{
		this.hours_minutes_seconds_value = hours_minutes_seconds_value;
	}

	public minutes_seconds_value getMinutes_seconds_value( )
	{
		return minutes_seconds_value;
	}

	public void setMinutes_seconds_value(
			minutes_seconds_value minutes_seconds_value )
	{
		this.minutes_seconds_value = minutes_seconds_value;
	}

	public seconds_value getSeconds_value( )
	{
		return seconds_value;
	}

	public void setSeconds_value( seconds_value seconds_value )
	{
		this.seconds_value = seconds_value;
	}

}
