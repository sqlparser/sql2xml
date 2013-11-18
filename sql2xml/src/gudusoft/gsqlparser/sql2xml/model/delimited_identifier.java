
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class delimited_identifier
{

	@Element(name = "double_quote")
	private String left_double_quote = "&quot;";

	@Element
	private String delimited_identifier_body;

	@Element(name = "double_quote")
	private String right_double_quote = "&quot;";

	public String getDelimited_identifier_body( )
	{
		return delimited_identifier_body;
	}

	public void setDelimited_identifier_body( String delimited_identifier_body )
	{
		this.delimited_identifier_body = delimited_identifier_body;
	}

}
