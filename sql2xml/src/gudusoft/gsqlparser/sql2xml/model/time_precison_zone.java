
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class time_precison_zone
{

	@Element
	private String kw_time = "time";

	@Element(required = false)
	private time_precision time_precision;

	@Element(required = false)
	private with_or_without_time_zone with_or_without_time_zone;

	public time_precision getTime_precision( )
	{
		return time_precision;
	}

	public void setTime_precision( time_precision time_precision )
	{
		this.time_precision = time_precision;
	}

	public with_or_without_time_zone getWith_or_without_time_zone( )
	{
		return with_or_without_time_zone;
	}

	public void setWith_or_without_time_zone(
			with_or_without_time_zone with_or_without_time_zone )
	{
		this.with_or_without_time_zone = with_or_without_time_zone;
	}

}
