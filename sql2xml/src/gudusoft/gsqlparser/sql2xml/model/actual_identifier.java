
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class actual_identifier
{

	@Element(required = false)
	private String regular_identifier;

	@Element(required = false)
	private delimited_identifier delimited_identifier;

	@Element(required = false)
	private unicode_delimited_identifier unicode_delimited_identifier;

	public String getRegular_identifier( )
	{
		return regular_identifier;
	}

	public void setRegular_identifier( String regular_identifier )
	{
		this.regular_identifier = regular_identifier;
	}

	public delimited_identifier getDelimited_identifier( )
	{
		return delimited_identifier;
	}

	public void setDelimited_identifier(
			delimited_identifier delimited_identifier )
	{
		this.delimited_identifier = delimited_identifier;
	}

	public unicode_delimited_identifier getUnicode_delimited_identifier( )
	{
		return unicode_delimited_identifier;
	}

	public void setUnicode_delimited_identifier(
			unicode_delimited_identifier unicode_delimited_identifier )
	{
		this.unicode_delimited_identifier = unicode_delimited_identifier;
	}

}
