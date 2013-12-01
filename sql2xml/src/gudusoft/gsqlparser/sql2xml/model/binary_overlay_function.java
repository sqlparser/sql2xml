
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class binary_overlay_function
{

	@Element
	private String kw_overlay = "overlay";

	@Element(name = "binary_value_expression")
	private binary_value_expression overlayExpression = new binary_value_expression( );

	@Element
	private String kw_placing = "placing";

	@Element(name = "binary_value_expression")
	private binary_value_expression placingExpression = new binary_value_expression( );

	@Element
	private from_start_position from_start_position = new from_start_position( );

	@Element(required = false)
	private for_string_length for_string_length;

	public for_string_length getFor_string_length( )
	{
		return for_string_length;
	}

	public void setFor_string_length( for_string_length for_string_length )
	{
		this.for_string_length = for_string_length;
	}

	public binary_value_expression getOverlayExpression( )
	{
		return overlayExpression;
	}

	public binary_value_expression getPlacingExpression( )
	{
		return placingExpression;
	}

	public from_start_position getFrom_start_position( )
	{
		return from_start_position;
	}

}
