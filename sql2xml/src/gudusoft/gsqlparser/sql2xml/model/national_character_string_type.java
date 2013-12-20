
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class national_character_string_type
{

	@Element(required = false)
	private national_character_length national_character_length;

	@Element(required = false)
	private national_char_with_length national_char_with_length;

	@Element(required = false)
	private nchar_with_length nchar_with_length;

	@Element(required = false)
	private national_character_varying_with_length national_character_varying_with_length;

	@Element(required = false)
	private national_char_varying_with_length national_char_varying_with_length;

	@Element(required = false)
	private nchar_varying_with_length nchar_varying_with_length;

	@Element(required = false)
	private national_character_large_object_type national_character_large_object_type;

	public national_character_length getNational_character_length( )
	{
		return national_character_length;
	}

	public void setNational_character_length(
			national_character_length national_character_length )
	{
		this.national_character_length = national_character_length;
	}

	public national_char_with_length getNational_char_with_length( )
	{
		return national_char_with_length;
	}

	public void setNational_char_with_length(
			national_char_with_length national_char_with_length )
	{
		this.national_char_with_length = national_char_with_length;
	}

	public nchar_with_length getNchar_with_length( )
	{
		return nchar_with_length;
	}

	public void setNchar_with_length( nchar_with_length nchar_with_length )
	{
		this.nchar_with_length = nchar_with_length;
	}

	public national_character_varying_with_length getNational_character_varying_with_length( )
	{
		return national_character_varying_with_length;
	}

	public void setNational_character_varying_with_length(
			national_character_varying_with_length national_character_varying_with_length )
	{
		this.national_character_varying_with_length = national_character_varying_with_length;
	}

	public national_char_varying_with_length getNational_char_varying_with_length( )
	{
		return national_char_varying_with_length;
	}

	public void setNational_char_varying_with_length(
			national_char_varying_with_length national_char_varying_with_length )
	{
		this.national_char_varying_with_length = national_char_varying_with_length;
	}

	public nchar_varying_with_length getNchar_varying_with_length( )
	{
		return nchar_varying_with_length;
	}

	public void setNchar_varying_with_length(
			nchar_varying_with_length nchar_varying_with_length )
	{
		this.nchar_varying_with_length = nchar_varying_with_length;
	}

	public national_character_large_object_type getNational_character_large_object_type( )
	{
		return national_character_large_object_type;
	}

	public void setNational_character_large_object_type(
			national_character_large_object_type national_character_large_object_type )
	{
		this.national_character_large_object_type = national_character_large_object_type;
	}

}
