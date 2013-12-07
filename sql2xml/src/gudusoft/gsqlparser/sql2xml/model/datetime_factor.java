
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class datetime_factor
{

	@Element
	private datetime_primary datetime_primary = new datetime_primary( );

	@Element(required = false)
	private time_zone time_zone;

	public time_zone getTime_zone( )
	{
		return time_zone;
	}

	public void setTime_zone( time_zone time_zone )
	{
		this.time_zone = time_zone;
	}

	public datetime_primary getDatetime_primary( )
	{
		return datetime_primary;
	}

}
