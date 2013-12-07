
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Text;

public class unicode_delimited_identifier
{

	@Element
	private String ampersand = "&";

	@Path("double_quote[1]")
	@Text
	private String left_double_quote = "\"";

	@Element
	private String unicode_delimiter_body;

	@Path("double_quote[2]")
	@Text
	private String right_double_quote = "\"";

	@Element(required = false)
	private unicode_escape_specifier unicode_escape_specifier;

	public String getUnicode_delimiter_body( )
	{
		return unicode_delimiter_body;
	}

	public void setUnicode_delimiter_body( String unicode_delimiter_body )
	{
		this.unicode_delimiter_body = unicode_delimiter_body;
	}

	public unicode_escape_specifier getUnicode_escape_specifier( )
	{
		return unicode_escape_specifier;
	}

	public void setUnicode_escape_specifier(
			unicode_escape_specifier unicode_escape_specifier )
	{
		this.unicode_escape_specifier = unicode_escape_specifier;
	}

}
