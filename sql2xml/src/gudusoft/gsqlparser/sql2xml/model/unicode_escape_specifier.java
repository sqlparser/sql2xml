
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Text;

public class unicode_escape_specifier
{

	@Path("double_quote[1]")
	@Text
	private String left_double_quote = "\"";

	@Element
	private String unicode_escape_character;

	@Path("double_quote[2]")
	@Text
	private String right_double_quote = "\"";

	public String getUnicode_escape_character( )
	{
		return unicode_escape_character;
	}

	public void setUnicode_escape_character( String unicode_escape_character )
	{
		this.unicode_escape_character = unicode_escape_character;
	}

}
