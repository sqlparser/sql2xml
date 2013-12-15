
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class unquoted_interval_string
{

	@Element(required = false)
	private sign sign;

	@Element
	private year_month_or_day_time_literal year_month_or_day_time_literal = new year_month_or_day_time_literal( );

	public year_month_or_day_time_literal getYear_month_or_day_time_literal( )
	{
		return year_month_or_day_time_literal;
	}

	public sign getSign( )
	{
		return sign;
	}

	public void setSign( sign sign )
	{
		this.sign = sign;
	}

}
