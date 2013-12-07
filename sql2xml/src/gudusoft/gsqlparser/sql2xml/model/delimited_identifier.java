
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Text;

public class delimited_identifier
{

	@Path("double_quote[1]")
	@Text
	private String left_double_quote = "\"";

	@Element
	private String delimited_identifier_body;

	@Path("double_quote[2]")
	@Text
	private String right_double_quote = "\"";

	public String getDelimited_identifier_body( )
	{
		return delimited_identifier_body;
	}

	public void setDelimited_identifier_body( String delimited_identifier_body )
	{
		this.delimited_identifier_body = delimited_identifier_body;
	}

}
