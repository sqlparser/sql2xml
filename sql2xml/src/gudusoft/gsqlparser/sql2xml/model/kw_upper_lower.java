
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class kw_upper_lower
{

	@Element(required = false)
	private String kw_upper;

	@Element(required = false)
	private String kw_lower;

	public String getKw_upper( )
	{
		return kw_upper;
	}

	public void setKw_upper( String kw_upper )
	{
		this.kw_upper = kw_upper;
	}

	public String getKw_lower( )
	{
		return kw_lower;
	}

	public void setKw_lower( String kw_lower )
	{
		this.kw_lower = kw_lower;
	}

}
