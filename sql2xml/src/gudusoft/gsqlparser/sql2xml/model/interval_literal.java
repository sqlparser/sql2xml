
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class interval_literal
{

	@Element
	private String kw_interval = "interval";

	@Element(required = false)
	private sign sign;

	@Element
	private interval_string interval_string = new interval_string( );

	@Element
	private interval_qualifier interval_qualifier = new interval_qualifier( );

	public sign getSign( )
	{
		return sign;
	}

	public void setSign( sign sign )
	{
		this.sign = sign;
	}

	public interval_string getInterval_string( )
	{
		return interval_string;
	}

	public interval_qualifier getInterval_qualifier( )
	{
		return interval_qualifier;
	}

}
