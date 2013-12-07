
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class time_zone_interval
{

	@Element
	private sign sign = new sign( );

	@Element
	private hours_value hours_value = new hours_value( );

	@Element
	private String colon = ":";

	@Element
	private minutes_value minutes_value = new minutes_value( );

	public sign getSign( )
	{
		return sign;
	}

	public hours_value getHours_value( )
	{
		return hours_value;
	}

	public minutes_value getMinutes_value( )
	{
		return minutes_value;
	}

}
