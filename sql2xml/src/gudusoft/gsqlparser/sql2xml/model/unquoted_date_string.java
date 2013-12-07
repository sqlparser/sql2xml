
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class unquoted_date_string
{

	@Element
	private date_value date_value = new date_value( );

	public date_value getDate_value( )
	{
		return date_value;
	}

}
