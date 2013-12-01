
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class trim_specification
{

	@Element(required = false)
	private String kw_leading;

	@Element(required = false)
	private String kw_trailing;

	@Element(required = false)
	private String kw_both;

	public String getKw_leading( )
	{
		return kw_leading;
	}

	public void setKw_leading( String kw_leading )
	{
		this.kw_leading = kw_leading;
	}

	public String getKw_trailing( )
	{
		return kw_trailing;
	}

	public void setKw_trailing( String kw_trailing )
	{
		this.kw_trailing = kw_trailing;
	}

	public String getKw_both( )
	{
		return kw_both;
	}

	public void setKw_both( String kw_both )
	{
		this.kw_both = kw_both;
	}

}
