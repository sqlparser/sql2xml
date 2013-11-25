
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class concatenation
{

	@Element
	private character_value_expression character_value_expression = new character_value_expression( );

	@Element
	private String concatenation_operator = "||";

	@Element
	private character_factor character_factor = new character_factor( );

	public character_value_expression getCharacter_value_expression( )
	{
		return character_value_expression;
	}

	public character_factor getCharacter_factor( )
	{
		return character_factor;
	}

}
