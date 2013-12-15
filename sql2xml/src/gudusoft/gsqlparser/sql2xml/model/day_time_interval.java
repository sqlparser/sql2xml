
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class day_time_interval
{

	@Element
	private days_value days_value = new days_value( );

	@Element(required = false)
	private hours_minutes_seconds_value hours_minutes_seconds_value;

	public hours_minutes_seconds_value getHours_minutes_seconds_value( )
	{
		return hours_minutes_seconds_value;
	}

	public void setHours_minutes_seconds_value(
			hours_minutes_seconds_value hours_minutes_seconds_value )
	{
		this.hours_minutes_seconds_value = hours_minutes_seconds_value;
	}

	public days_value getDays_value( )
	{
		return days_value;
	}

}
