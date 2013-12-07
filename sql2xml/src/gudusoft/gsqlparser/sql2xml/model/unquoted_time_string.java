
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class unquoted_time_string
{

	@Element
	private time_value time_value = new time_value( );

	@Element(required = false)
	private time_zone_interval time_zone_interval;

	public time_zone_interval getTime_zone_interval( )
	{
		return time_zone_interval;
	}

	public void setTime_zone_interval( time_zone_interval time_zone_interval )
	{
		this.time_zone_interval = time_zone_interval;
	}

	public time_value getTime_value( )
	{
		return time_value;
	}

}
