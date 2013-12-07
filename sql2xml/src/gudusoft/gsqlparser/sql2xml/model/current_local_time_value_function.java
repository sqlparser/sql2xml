
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class current_local_time_value_function
{

	@Element
	private String kw_localtime = "localtime";

	@Element(required = false)
	private time_precision time_precision;

	public time_precision getTime_precision( )
	{
		return time_precision;
	}

	public void setTime_precision( time_precision time_precision )
	{
		this.time_precision = time_precision;
	}

}
