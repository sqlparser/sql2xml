
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class set_quantifier
{

	@Element(required = false)
	private String kw_distinct;

	@Element(required = false)
	private String kw_all;

	
	public String getKw_distinct( )
	{
		return kw_distinct;
	}

	
	public void setKw_distinct( String kw_distinct )
	{
		this.kw_distinct = kw_distinct;
	}

	
	public String getKw_all( )
	{
		return kw_all;
	}

	
	public void setKw_all( String kw_all )
	{
		this.kw_all = kw_all;
	}
}
