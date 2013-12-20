
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class char_with_length
{

	@Element
	private String kw_char = "char";

	@Element(required = false)
	private length length;

	public length getLength( )
	{
		return length;
	}

	public void setLength( length length )
	{
		this.length = length;
	}

}
