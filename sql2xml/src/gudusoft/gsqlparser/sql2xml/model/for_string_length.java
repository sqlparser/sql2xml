
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class for_string_length
{

	@Element
	private String kw_for = "for";

	@Element
	private string_length string_length = new string_length( );

	public string_length getString_length( )
	{
		return string_length;
	}

}
