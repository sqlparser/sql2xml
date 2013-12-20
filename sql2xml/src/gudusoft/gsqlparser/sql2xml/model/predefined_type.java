
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class predefined_type
{

	@Element(required = false)
	private character_string_type_with_charater_set_collate character_string_type_with_charater_set_collate;

	@Element(required = false)
	private national_character_string_type_with_collate national_character_string_type_with_collate;

	@Element(required = false)
	private binary_string_type binary_string_type;

	@Element(required = false)
	private numeric_type numeric_type;

	@Element(required = false)
	private boolean_type boolean_type;

	@Element(required = false)
	private datetime_type datetime_type;

	@Element(required = false)
	private interval_type interval_type;

	public character_string_type_with_charater_set_collate getCharacter_string_type_with_charater_set_collate( )
	{
		return character_string_type_with_charater_set_collate;
	}

	public void setCharacter_string_type_with_charater_set_collate(
			character_string_type_with_charater_set_collate character_string_type_with_charater_set_collate )
	{
		this.character_string_type_with_charater_set_collate = character_string_type_with_charater_set_collate;
	}

	public national_character_string_type_with_collate getNational_character_string_type_with_collate( )
	{
		return national_character_string_type_with_collate;
	}

	public void setNational_character_string_type_with_collate(
			national_character_string_type_with_collate national_character_string_type_with_collate )
	{
		this.national_character_string_type_with_collate = national_character_string_type_with_collate;
	}

	public binary_string_type getBinary_string_type( )
	{
		return binary_string_type;
	}

	public void setBinary_string_type( binary_string_type binary_string_type )
	{
		this.binary_string_type = binary_string_type;
	}

	public numeric_type getNumeric_type( )
	{
		return numeric_type;
	}

	public void setNumeric_type( numeric_type numeric_type )
	{
		this.numeric_type = numeric_type;
	}

	public boolean_type getBoolean_type( )
	{
		return boolean_type;
	}

	public void setBoolean_type( boolean_type boolean_type )
	{
		this.boolean_type = boolean_type;
	}

	public datetime_type getDatetime_type( )
	{
		return datetime_type;
	}

	public void setDatetime_type( datetime_type datetime_type )
	{
		this.datetime_type = datetime_type;
	}

	public interval_type getInterval_type( )
	{
		return interval_type;
	}

	public void setInterval_type( interval_type interval_type )
	{
		this.interval_type = interval_type;
	}

}
