
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class year_month_or_day_time_literal
{

	@Element(required = false)
	private year_month_literal year_month_literal;

	@Element(required = false)
	private day_time_literal day_time_literal;

	public year_month_literal getYear_month_literal( )
	{
		return year_month_literal;
	}

	public void setYear_month_literal( year_month_literal year_month_literal )
	{
		this.year_month_literal = year_month_literal;
	}

	public day_time_literal getDay_time_literal( )
	{
		return day_time_literal;
	}

	public void setDay_time_literal( day_time_literal day_time_literal )
	{
		this.day_time_literal = day_time_literal;
	}

}
