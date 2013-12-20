
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class character_large_object_type
{

	@Element(required = false)
	private character_large_object_with_length character_large_object_with_length;

	@Element(required = false)
	private char_large_object_with_length char_large_object_with_length;

	@Element(required = false)
	private clob_with_length clob_with_length;

	public character_large_object_with_length getCharacter_large_object_with_length( )
	{
		return character_large_object_with_length;
	}

	public void setCharacter_large_object_with_length(
			character_large_object_with_length character_large_object_with_length )
	{
		this.character_large_object_with_length = character_large_object_with_length;
	}

	public char_large_object_with_length getChar_large_object_with_length( )
	{
		return char_large_object_with_length;
	}

	public void setChar_large_object_with_length(
			char_large_object_with_length char_large_object_with_length )
	{
		this.char_large_object_with_length = char_large_object_with_length;
	}

	public clob_with_length getClob_with_length( )
	{
		return clob_with_length;
	}

	public void setClob_with_length( clob_with_length clob_with_length )
	{
		this.clob_with_length = clob_with_length;
	}

}
