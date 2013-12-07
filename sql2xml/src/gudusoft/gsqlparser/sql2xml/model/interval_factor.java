
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class interval_factor
{

	@Element(required = false)
	private sign sign;

	@Element
	private interval_primary interval_primary = new interval_primary( );

	public sign getSign( )
	{
		return sign;
	}

	public void setSign( sign sign )
	{
		this.sign = sign;
	}

	public interval_primary getInterval_primary( )
	{
		return interval_primary;
	}

}
