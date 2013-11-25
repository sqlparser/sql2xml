
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class kw_ceil_ceiling
{

	@Element(required = false)
	private String kw_ceil;

	@Element(required = false)
	private String kw_ceiling;

	public String getKw_ceil( )
	{
		return kw_ceil;
	}

	public void setKw_ceil( String kw_ceil )
	{
		this.kw_ceil = kw_ceil;
	}

	public String getKw_ceiling( )
	{
		return kw_ceiling;
	}

	public void setKw_ceiling( String kw_ceiling )
	{
		this.kw_ceiling = kw_ceiling;
	}

}
