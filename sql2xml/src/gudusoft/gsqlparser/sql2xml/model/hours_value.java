package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class hours_value
{
	@Element
	private datetime_value datetime_value = new datetime_value( );

	public datetime_value getDatetime_value( )
	{
		return datetime_value;
	}
}
