
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class timestamp_literal
{

	@Element
	private String kw_timestamp = "timestamp";

	@Element
	private timestamp_string timestamp_string = new timestamp_string( );

	public timestamp_string getTimestamp_string( )
	{
		return timestamp_string;
	}

}
