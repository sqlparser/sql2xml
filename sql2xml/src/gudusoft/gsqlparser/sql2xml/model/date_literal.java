
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class date_literal
{

	@Element
	private String kw_date = "date";

	@Element
	private date_string date_string = new date_string( );

	public date_string getDate_string( )
	{
		return date_string;
	}

}
