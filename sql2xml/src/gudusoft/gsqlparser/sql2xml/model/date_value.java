
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Text;

public class date_value
{

	@Element
	private years_value years_value = new years_value( );

	@Path("minus_sign[1]")
	@Text
	private String first_minus_sign = "-";

	@Element
	private months_value months_value = new months_value( );

	@Path("minus_sign[2]")
	@Text
	private String second_minus_sign = "-";

	@Element
	private days_value days_value = new days_value( );

	public years_value getYears_value( )
	{
		return years_value;
	}

	public months_value getMonths_value( )
	{
		return months_value;
	}

	public days_value getDays_value( )
	{
		return days_value;
	}

}
