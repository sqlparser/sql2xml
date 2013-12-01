
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class character_overlay_function
{

	@Element
	private String kw_overlay = "overlay";

	@Element(name = "character_value_expression")
	private character_value_expression overlayExpression = new character_value_expression( );

	@Element
	private String kw_placing = "placing";

	@Element(name = "character_value_expression")
	private character_value_expression placingExpression = new character_value_expression( );

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

	public character_value_expression getOverlayExpression( )
	{
		return overlayExpression;
	}

	public character_value_expression getPlacingExpression( )
	{
		return placingExpression;
	}

	public from_start_position getFrom_start_position( )
	{
		return from_start_position;
	}

}
