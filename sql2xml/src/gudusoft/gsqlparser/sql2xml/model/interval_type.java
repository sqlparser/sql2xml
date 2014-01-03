
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class interval_type
{

	@Element
	private String kw_interval = "interval";

	@Element
	private interval_qualifier interval_qualifier = new interval_qualifier( );

	public interval_qualifier getInterval_qualifier( )
	{
		return interval_qualifier;
	}

}
