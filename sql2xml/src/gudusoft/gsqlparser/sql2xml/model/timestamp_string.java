
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Text;

public class timestamp_string
{

	@Path("quote[1]")
	@Text
	private String leftQuote = "'";

	@Element
	private unquoted_timestamp_string unquoted_timestamp_string = new unquoted_timestamp_string( );

	@Path("quote[2]")
	@Text
	private String rightQuote = "'";

	public unquoted_timestamp_string getUnquoted_timestamp_string( )
	{
		return unquoted_timestamp_string;
	}
}
