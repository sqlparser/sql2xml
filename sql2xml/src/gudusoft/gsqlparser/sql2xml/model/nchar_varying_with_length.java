
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class nchar_varying_with_length
{

	@Element
	private String kw_nchar = "nchar";

	@Element
	private String kw_varying = "varying";

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
