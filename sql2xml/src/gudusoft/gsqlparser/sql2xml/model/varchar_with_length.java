
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class varchar_with_length
{

	@Element
	private String kw_varchar = "varchar";

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
