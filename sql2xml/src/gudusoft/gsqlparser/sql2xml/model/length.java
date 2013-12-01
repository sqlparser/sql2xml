
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class length
{

	@Element
	private String unsigned_integer;

	@Element(required = false)
	private char_length_units char_length_units;

	public String getUnsigned_integer( )
	{
		return unsigned_integer;
	}

	public void setUnsigned_integer( String unsigned_integer )
	{
		this.unsigned_integer = unsigned_integer;
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
