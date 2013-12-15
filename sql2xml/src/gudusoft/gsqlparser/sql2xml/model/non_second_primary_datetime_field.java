
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class non_second_primary_datetime_field
{

	@Element(required = false)
	private String kw_year;

	@Element(required = false)
	private String kw_month;

	@Element(required = false)
	private String kw_day;

	@Element(required = false)
	private String kw_hour;

	@Element(required = false)
	private String kw_minute;

	public String getKw_year( )
	{
		return kw_year;
	}

	public void setKw_year( String kw_year )
	{
		this.kw_year = kw_year;
	}

	public String getKw_month( )
	{
		return kw_month;
	}

	public void setKw_month( String kw_month )
	{
		this.kw_month = kw_month;
	}

	public String getKw_day( )
	{
		return kw_day;
	}

	public void setKw_day( String kw_day )
	{
		this.kw_day = kw_day;
	}

	public String getKw_hour( )
	{
		return kw_hour;
	}

	public void setKw_hour( String kw_hour )
	{
		this.kw_hour = kw_hour;
	}

	public String getKw_minute( )
	{
		return kw_minute;
	}

	public void setKw_minute( String kw_minute )
	{
		this.kw_minute = kw_minute;
	}

}
