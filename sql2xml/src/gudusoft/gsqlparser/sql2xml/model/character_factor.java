
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class character_factor
{

	@Element
	private character_primary character_primary = new character_primary( );

	@Element(required = false)
	private collate_clause collate_clause;

	public collate_clause getCollate_clause( )
	{
		return collate_clause;
	}

	public void setCollate_clause( collate_clause collate_clause )
	{
		this.collate_clause = collate_clause;
	}

	public character_primary getCharacter_primary( )
	{
		return character_primary;
	}

}
