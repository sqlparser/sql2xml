
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class character_pattern
{

	@Element
	private character_value_expression character_value_expression = new character_value_expression( );

	public character_value_expression getCharacter_value_expression( )
	{
		return character_value_expression;
	}

}
