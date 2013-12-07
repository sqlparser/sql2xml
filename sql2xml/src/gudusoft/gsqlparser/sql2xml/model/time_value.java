
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Text;

public class time_value
{

	@Element
	private hours_value hours_value = new hours_value( );

	@Path("colon[1]")
	@Text
	private String first_colon = ":";

	@Element
	private minutes_value minutes_value = new minutes_value( );

	@Path("colon[2]")
	@Text
	private String second_colon = ":";

	@Element
	private seconds_value seconds_value = new seconds_value( );

	public hours_value getHours_value( )
	{
		return hours_value;
	}

	public minutes_value getMinutes_value( )
	{
		return minutes_value;
	}

	public seconds_value getSeconds_value( )
	{
		return seconds_value;
	}

}
