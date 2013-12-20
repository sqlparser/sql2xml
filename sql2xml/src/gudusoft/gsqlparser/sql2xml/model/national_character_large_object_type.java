
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class national_character_large_object_type
{

	@Element(required = false)
	private national_character_large_object_with_length national_character_large_object_with_length;

	@Element(required = false)
	private nchar_large_object_with_length nchar_large_object_with_length;

	@Element(required = false)
	private nclob_with_length nclob_with_length;

	public national_character_large_object_with_length getNational_character_large_object_with_length( )
	{
		return national_character_large_object_with_length;
	}

	public void setNational_character_large_object_with_length(
			national_character_large_object_with_length national_character_large_object_with_length )
	{
		this.national_character_large_object_with_length = national_character_large_object_with_length;
	}

	public nchar_large_object_with_length getNchar_large_object_with_length( )
	{
		return nchar_large_object_with_length;
	}

	public void setNchar_large_object_with_length(
			nchar_large_object_with_length nchar_large_object_with_length )
	{
		this.nchar_large_object_with_length = nchar_large_object_with_length;
	}

	public nclob_with_length getNclob_with_length( )
	{
		return nclob_with_length;
	}

	public void setNclob_with_length( nclob_with_length nclob_with_length )
	{
		this.nclob_with_length = nclob_with_length;
	}

}
