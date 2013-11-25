
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class char_length_expression
{

	@Element
	private char_or_character_length char_or_character_length = new char_or_character_length( );

	@Element
	private character_value_expression character_value_expression = new character_value_expression( );

	@Element(required = false)
	private using_char_length_units using_char_length_units = new using_char_length_units( );

	public using_char_length_units getUsing_char_length_units( )
	{
		return using_char_length_units;
	}

	public void setUsing_char_length_units(
			using_char_length_units using_char_length_units )
	{
		this.using_char_length_units = using_char_length_units;
	}

	public char_or_character_length getChar_or_character_length( )
	{
		return char_or_character_length;
	}

	public character_value_expression getCharacter_value_expression( )
	{
		return character_value_expression;
	}

}
