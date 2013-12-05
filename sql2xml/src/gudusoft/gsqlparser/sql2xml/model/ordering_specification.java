
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class ordering_specification
{

	@Element(required = false)
	private String kw_asc;

	@Element(required = false)
	private String kw_desc;

	public String getKw_asc( )
	{
		return kw_asc;
	}

	public void setKw_asc( String kw_asc )
	{
		this.kw_asc = kw_asc;
	}

	public String getKw_desc( )
	{
		return kw_desc;
	}

	public void setKw_desc( String kw_desc )
	{
		this.kw_desc = kw_desc;
	}

}
