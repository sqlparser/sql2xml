
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class escape_character_clause
{

	@Element
	private String kw_escape = "escape";

	@Element
	private escape_character escape_character = new escape_character( );

	public escape_character getEscape_character( )
	{
		return escape_character;
	}

}
