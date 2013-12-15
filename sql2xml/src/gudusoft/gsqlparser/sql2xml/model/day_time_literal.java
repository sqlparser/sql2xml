
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class day_time_literal
{

	@Element(required = false)
	private day_time_interval day_time_interval;

	@Element(required = false)
	private time_interval time_interval;

	public day_time_interval getDay_time_interval( )
	{
		return day_time_interval;
	}

	public void setDay_time_interval( day_time_interval day_time_interval )
	{
		this.day_time_interval = day_time_interval;
	}

	public time_interval getTime_interval( )
	{
		return time_interval;
	}

	public void setTime_interval( time_interval time_interval )
	{
		this.time_interval = time_interval;
	}

}
