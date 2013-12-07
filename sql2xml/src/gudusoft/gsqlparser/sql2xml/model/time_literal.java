
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class time_literal
{

	@Element
	private String kw_time = "time";

	@Element
	private time_string time_string = new time_string( );

	public time_string getTime_string( )
	{
		return time_string;
	}

}
