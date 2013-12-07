
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class unquoted_timestamp_string
{

	@Element
	private unquoted_date_string unquoted_date_string = new unquoted_date_string( );

	@Element
	private unquoted_time_string unquoted_time_string = new unquoted_time_string( );

	public unquoted_date_string getUnquoted_date_string( )
	{
		return unquoted_date_string;
	}

	public void setUnquoted_date_string(
			unquoted_date_string unquoted_date_string )
	{
		this.unquoted_date_string = unquoted_date_string;
	}

	public unquoted_time_string getUnquoted_time_string( )
	{
		return unquoted_time_string;
	}

	public void setUnquoted_time_string(
			unquoted_time_string unquoted_time_string )
	{
		this.unquoted_time_string = unquoted_time_string;
	}

}
