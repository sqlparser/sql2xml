
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class datetime_term
{

	@Element
	private datetime_factor datetime_factor = new datetime_factor( );

	public datetime_factor getDatetime_factor( )
	{
		return datetime_factor;
	}

}
