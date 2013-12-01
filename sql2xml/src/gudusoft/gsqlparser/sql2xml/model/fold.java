
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class fold
{

	@Element
	private kw_upper_lower kw_upper_lower = new kw_upper_lower( );

	@Element
	character_value_expression character_value_expression = new character_value_expression( );

	public kw_upper_lower getKw_upper_lower( )
	{
		return kw_upper_lower;
	}

	public character_value_expression getCharacter_value_expression( )
	{
		return character_value_expression;
	}

}
