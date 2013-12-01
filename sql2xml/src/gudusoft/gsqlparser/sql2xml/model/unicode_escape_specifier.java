
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class unicode_escape_specifier
{

	@Element(name = "double_quote")
	private String left_double_quote = "&quot;";

	@Element
	private String unicode_escape_character;

	@Element(name = "double_quote")
	private String right_double_quote = "&quot;";

	public String getUnicode_escape_character( )
	{
		return unicode_escape_character;
	}

	public void setUnicode_escape_character( String unicode_escape_character )
	{
		this.unicode_escape_character = unicode_escape_character;
	}

}
