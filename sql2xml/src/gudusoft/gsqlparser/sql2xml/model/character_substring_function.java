
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class character_substring_function
{

	@Element
	private String kw_substring = "substring";

	@Element
	private character_value_expression character_value_expression = new character_value_expression( );

	@Element
	private from_start_position from_start_position = new from_start_position( );

	@Element(required = false)
	private for_string_length for_string_length;

	@Element(required = false)
	private using_char_length_units using_char_length_units;

	public for_string_length getFor_string_length( )
	{
		return for_string_length;
	}

	public void setFor_string_length( for_string_length for_string_length )
	{
		this.for_string_length = for_string_length;
	}

	public using_char_length_units getUsing_char_length_units( )
	{
		return using_char_length_units;
	}

	public void setUsing_char_length_units(
			using_char_length_units using_char_length_units )
	{
		this.using_char_length_units = using_char_length_units;
	}

	public character_value_expression getCharacter_value_expression( )
	{
		return character_value_expression;
	}

	public from_start_position getFrom_start_position( )
	{
		return from_start_position;
	}

}
