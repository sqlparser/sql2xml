package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class unsigned_integer_multiplier_with_length_units
{

	@Element
	private String unsigned_integer;

	@Element(required = false)
	private String multiplier;

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

	public String getMultiplier( )
	{
		return multiplier;
	}

	public void setMultiplier( String multiplier )
	{
		this.multiplier = multiplier;
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
