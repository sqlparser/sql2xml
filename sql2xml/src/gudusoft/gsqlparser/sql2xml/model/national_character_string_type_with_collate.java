
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class national_character_string_type_with_collate
{

	@Element
	private national_character_string_type national_character_string_type = new national_character_string_type( );

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

	public national_character_string_type getNational_character_string_type( )
	{
		return national_character_string_type;
	}

}
