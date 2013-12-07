
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Text;

public class date_string
{

	@Path("quote[1]")
	@Text
	private String leftQuote = "'";

	@Element
	private unquoted_date_string unquoted_date_string = new unquoted_date_string( );

	@Path("quote[2]")
	@Text
	private String rightQuote = "'";

	public unquoted_date_string getUnquoted_date_string( )
	{
		return unquoted_date_string;
	}

}
