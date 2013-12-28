
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class character_like_predicate_part_2
{

	@Element(required = false)
	private String kw_not;

	@Element
	private String kw_like = "like";

	@Element
	private character_pattern character_pattern = new character_pattern( );

	@Element(required = false)
	private escape_character_clause escape_character_clause;

	public String getKw_not( )
	{
		return kw_not;
	}

	public void setKw_not( String kw_not )
	{
		this.kw_not = kw_not;
	}

	public escape_character_clause getEscape_character_clause( )
	{
		return escape_character_clause;
	}

	public void setEscape_character_clause(
			escape_character_clause escape_character_clause )
	{
		this.escape_character_clause = escape_character_clause;
	}

	public character_pattern getCharacter_pattern( )
	{
		return character_pattern;
	}

}
