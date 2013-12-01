
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class regular_expression_substring_function
{

	@Element
	private String kw_substring = "substring";

	@Element(name = "character_value_expression")
	private character_value_expression substringExpression = new character_value_expression( );

	@Element
	private String kw_similar = "similar";

	@Element(name = "character_value_expression")
	private character_value_expression similarExpression = new character_value_expression( );

	@Element
	private String kw_escape = "escape";

	@Element
	private escape_character escape_character = new escape_character( );

	public character_value_expression getSubstringExpression( )
	{
		return substringExpression;
	}

	public character_value_expression getSimilarExpression( )
	{
		return similarExpression;
	}

	public escape_character getEscape_character( )
	{
		return escape_character;
	}

}
