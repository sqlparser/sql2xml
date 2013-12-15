
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class minutes_seconds_value
{

	@Element
	private minutes_value minutes_value = new minutes_value( );

	@Element(required = false)
	private seconds_value seconds_value;

	public seconds_value getSeconds_value( )
	{
		return seconds_value;
	}

	public void setSeconds_value( seconds_value seconds_value )
	{
		this.seconds_value = seconds_value;
	}

	public minutes_value getMinutes_value( )
	{
		return minutes_value;
	}

}
