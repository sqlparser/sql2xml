
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class char_length_units
{

	@Element(required = false)
	private String kw_characters;

	@Element(required = false)
	private String kw_octets;

	public String getKw_characters( )
	{
		return kw_characters;
	}

	public String getKw_octets( )
	{
		return kw_octets;
	}

}
