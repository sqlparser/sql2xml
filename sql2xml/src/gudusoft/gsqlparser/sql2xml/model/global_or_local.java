
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class global_or_local
{

	@Element(required = false)
	private String kw_global;

	@Element(required = false)
	private String kw_local;

	public String getKw_global( )
	{
		return kw_global;
	}

	public void setKw_global( String kw_global )
	{
		this.kw_global = kw_global;
	}

	public String getKw_local( )
	{
		return kw_local;
	}

	public void setKw_local( String kw_local )
	{
		this.kw_local = kw_local;
	}

}
