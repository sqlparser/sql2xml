
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class time_precision
{

	@Element
	private time_fractional_seconds_precision time_fractional_seconds_precision = new time_fractional_seconds_precision( );

	public time_fractional_seconds_precision getTime_fractional_seconds_precision( )
	{
		return time_fractional_seconds_precision;
	}

}
