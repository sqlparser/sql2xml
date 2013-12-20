
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class with_or_without_time_zone
{

	@Element(required = false)
	private with_time_zone with_time_zone;

	@Element(required = false)
	private without_time_zone without_time_zone;

	public with_time_zone getWith_time_zone( )
	{
		return with_time_zone;
	}

	public void setWith_time_zone( with_time_zone with_time_zone )
	{
		this.with_time_zone = with_time_zone;
	}

	public without_time_zone getWithout_time_zone( )
	{
		return without_time_zone;
	}

	public void setWithout_time_zone( without_time_zone without_time_zone )
	{
		this.without_time_zone = without_time_zone;
	}

}
