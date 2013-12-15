
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Text;

public class interval_string
{

	@Path("quote[1]")
	@Text
	private String leftQuote = "'";

	@Element
	private unquoted_interval_string unquoted_interval_string = new unquoted_interval_string( );

	@Path("quote[2]")
	@Text
	private String rightQuote = "'";

	public unquoted_interval_string getUnquoted_interval_string( )
	{
		return unquoted_interval_string;
	}

}
