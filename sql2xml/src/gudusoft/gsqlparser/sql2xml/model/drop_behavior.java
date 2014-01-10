
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class drop_behavior
{

	@Element(required = false)
	private String kw_cascade;

	@Element(required = false)
	private String kw_restrict;

	public String getKw_cascade( )
	{
		return kw_cascade;
	}

	public void setKw_cascade( String kw_cascade )
	{
		this.kw_cascade = kw_cascade;
	}

	public String getKw_restrict( )
	{
		return kw_restrict;
	}

	public void setKw_restrict( String kw_restrict )
	{
		this.kw_restrict = kw_restrict;
	}

}
