
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class datetime_type
{

	@Element(required = false)
	private String kw_date;

	@Element(required = false)
	private time_precison_zone time_precison_zone;

	@Element(required = false)
	private timestamp_precision_zone timestamp_precision_zone;

	public String getKw_date( )
	{
		return kw_date;
	}

	public void setKw_date( String kw_date )
	{
		this.kw_date = kw_date;
	}

	public time_precison_zone getTime_precison_zone( )
	{
		return time_precison_zone;
	}

	public void setTime_precison_zone( time_precison_zone time_precison_zone )
	{
		this.time_precison_zone = time_precison_zone;
	}

	public timestamp_precision_zone getTimestamp_precision_zone( )
	{
		return timestamp_precision_zone;
	}

	public void setTimestamp_precision_zone(
			timestamp_precision_zone timestamp_precision_zone )
	{
		this.timestamp_precision_zone = timestamp_precision_zone;
	}

}
