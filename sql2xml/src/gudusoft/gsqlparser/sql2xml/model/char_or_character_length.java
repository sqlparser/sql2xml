
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class char_or_character_length
{

	@Element(required = false)
	private String kw_char_length;

	@Element(required = false)
	private String kw_character_length;

	public String getKw_char_length( )
	{
		return kw_char_length;
	}

	public void setKw_char_length( String kw_char_length )
	{
		this.kw_char_length = kw_char_length;
	}

	public String getKw_character_length( )
	{
		return kw_character_length;
	}

	public void setKw_character_length( String kw_character_length )
	{
		this.kw_character_length = kw_character_length;
	}

}
