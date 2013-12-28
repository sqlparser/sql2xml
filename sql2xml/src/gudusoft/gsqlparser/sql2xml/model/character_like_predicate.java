
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class character_like_predicate
{

	@Element
	private row_value_predicand row_value_predicand = new row_value_predicand( );

	@Element
	private character_like_predicate_part_2 character_like_predicate_part_2 = new character_like_predicate_part_2( );

	public row_value_predicand getRow_value_predicand( )
	{
		return row_value_predicand;
	}

	public character_like_predicate_part_2 getCharacter_like_predicate_part_2( )
	{
		return character_like_predicate_part_2;
	}

}
