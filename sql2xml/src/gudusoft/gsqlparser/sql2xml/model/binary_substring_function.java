
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class binary_substring_function
{

	@Element
	private String kw_substring = "substring";

	@Element
	private binary_value_expression binary_value_expression = new binary_value_expression( );

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

	public binary_value_expression getBinary_value_expression( )
	{
		return binary_value_expression;
	}

	public from_start_position getFrom_start_position( )
	{
		return from_start_position;
	}

}
