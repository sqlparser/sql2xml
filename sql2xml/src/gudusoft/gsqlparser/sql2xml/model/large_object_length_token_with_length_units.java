
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class large_object_length_token_with_length_units
{

	@Element
	private large_object_length_token large_object_length_token = new large_object_length_token( );

	@Element(required = false)
	private char_length_units char_length_units;

	public large_object_length_token getLarge_object_length_token( )
	{
		return large_object_length_token;
	}

	public char_length_units getChar_length_units( )
	{
		return char_length_units;
	}

	public void setChar_length_units( char_length_units char_length_units )
	{
		this.char_length_units = char_length_units;
	}

}
