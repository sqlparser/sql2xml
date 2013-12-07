
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class outer_join_type
{

	@Element(required = false)
	private String kw_left;

	@Element(required = false)
	private String kw_right;

	@Element(required = false)
	private String kw_full;

	public String getKw_left( )
	{
		return kw_left;
	}

	public void setKw_left( String kw_left )
	{
		this.kw_left = kw_left;
	}

	public String getKw_right( )
	{
		return kw_right;
	}

	public void setKw_right( String kw_right )
	{
		this.kw_right = kw_right;
	}

	public String getKw_full( )
	{
		return kw_full;
	}

	public void setKw_full( String kw_full )
	{
		this.kw_full = kw_full;
	}

}
