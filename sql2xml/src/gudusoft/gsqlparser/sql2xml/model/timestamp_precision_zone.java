
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class timestamp_precision_zone
{

	@Element
	private String kw_timestamp = "timestamp";

	@Element(required = false)
	private timestamp_precision timestamp_precision;

	@Element(required = false)
	private with_or_without_time_zone with_or_without_time_zone;

	
	public timestamp_precision getTimestamp_precision( )
	{
		return timestamp_precision;
	}

	
	public void setTimestamp_precision( timestamp_precision timestamp_precision )
	{
		this.timestamp_precision = timestamp_precision;
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
