
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class character_position_expression
{

	@Element
	private String kw_position = "position";

	@Element
	private character_value_expression_1 character_value_expression_1 = new character_value_expression_1( );

	@Element
	private String kw_in = "in";

	@Element
	private character_value_expression_2 character_value_expression_2 = new character_value_expression_2( );

	@Element(required = false)
	private using_char_length_units using_char_length_units;

	public using_char_length_units getUsing_char_length_units( )
	{
		return using_char_length_units;
	}

	public void setUsing_char_length_units(
			using_char_length_units using_char_length_units )
	{
		this.using_char_length_units = using_char_length_units;
	}

	public character_value_expression_1 getCharacter_value_expression_1( )
	{
		return character_value_expression_1;
	}

	public character_value_expression_2 getCharacter_value_expression_2( )
	{
		return character_value_expression_2;
	}

}
