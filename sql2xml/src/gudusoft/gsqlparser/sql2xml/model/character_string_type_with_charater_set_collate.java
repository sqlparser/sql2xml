
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class character_string_type_with_charater_set_collate
{

	@Element
	private character_string_type character_string_type = new character_string_type( );

	@Element(required = false)
	private character_set_specification character_set_specification;

	@Element(required = false)
	private collate_clause collate_clause;

	public character_set_specification getCharacter_set_specification( )
	{
		return character_set_specification;
	}

	public void setCharacter_set_specification(
			character_set_specification character_set_specification )
	{
		this.character_set_specification = character_set_specification;
	}

	public collate_clause getCollate_clause( )
	{
		return collate_clause;
	}

	public void setCollate_clause( collate_clause collate_clause )
	{
		this.collate_clause = collate_clause;
	}

	public character_string_type getCharacter_string_type( )
	{
		return character_string_type;
	}

}
