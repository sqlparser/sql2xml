
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class some
{

	@Element(required = false)
	private String kw_some;

	@Element(required = false)
	private String kw_any;

	public String getKw_some( )
	{
		return kw_some;
	}

	public void setKw_some( String kw_some )
	{
		this.kw_some = kw_some;
	}

	public String getKw_any( )
	{
		return kw_any;
	}

	public void setKw_any( String kw_any )
	{
		this.kw_any = kw_any;
	}

}
