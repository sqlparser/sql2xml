
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class character_string_type
{

	@Element(required = false)
	private character_with_length character_with_length;

	@Element(required = false)
	private char_with_length char_with_length;

	@Element(required = false)
	private character_varying_with_length character_varying_with_length;

	@Element(required = false)
	private char_varying char_varying;

	@Element(required = false)
	private varchar_with_length varchar_with_length;

	@Element(required = false)
	private character_large_object_type character_large_object_type;

	public character_with_length getCharacter_with_length( )
	{
		return character_with_length;
	}

	public void setCharacter_with_length(
			character_with_length character_with_length )
	{
		this.character_with_length = character_with_length;
	}

	public char_with_length getChar_with_length( )
	{
		return char_with_length;
	}

	public void setChar_with_length( char_with_length char_with_length )
	{
		this.char_with_length = char_with_length;
	}

	public character_varying_with_length getCharacter_varying_with_length( )
	{
		return character_varying_with_length;
	}

	public void setCharacter_varying_with_length(
			character_varying_with_length character_varying_with_length )
	{
		this.character_varying_with_length = character_varying_with_length;
	}

	public char_varying getChar_varying( )
	{
		return char_varying;
	}

	public void setChar_varying( char_varying char_varying )
	{
		this.char_varying = char_varying;
	}

	public varchar_with_length getVarchar_with_length( )
	{
		return varchar_with_length;
	}

	public void setVarchar_with_length( varchar_with_length varchar_with_length )
	{
		this.varchar_with_length = varchar_with_length;
	}

	public character_large_object_type getCharacter_large_object_type( )
	{
		return character_large_object_type;
	}

	public void setCharacter_large_object_type(
			character_large_object_type character_large_object_type )
	{
		this.character_large_object_type = character_large_object_type;
	}

}
