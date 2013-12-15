
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class hours_minutes_seconds_value
{

	@Element
	private hours_value hours_value = new hours_value( );

	@Element(required = false)
	private minutes_seconds_value minutes_seconds_value;

	public minutes_seconds_value getMinutes_seconds_value( )
	{
		return minutes_seconds_value;
	}

	public void setMinutes_seconds_value(
			minutes_seconds_value minutes_seconds_value )
	{
		this.minutes_seconds_value = minutes_seconds_value;
	}

	public hours_value getHours_value( )
	{
		return hours_value;
	}

}
