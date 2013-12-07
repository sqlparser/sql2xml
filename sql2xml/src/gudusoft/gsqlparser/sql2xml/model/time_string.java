
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Text;

public class time_string
{

	@Path("quote[1]")
	@Text
	private String leftQuote = "'";

	@Element
	private unquoted_time_string unquoted_time_string = new unquoted_time_string( );

	@Path("quote[2]")
	@Text
	private String rightQuote = "'";

	public unquoted_time_string getUnquoted_time_string( )
	{
		return unquoted_time_string;
	}

}
