
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class quantifier
{

	@Element(required = false)
	private String kw_all;

	@Element(required = false)
	private some some;

	public String getKw_all( )
	{
		return kw_all;
	}

	public void setKw_all( String kw_all )
	{
		this.kw_all = kw_all;
	}

	public some getSome( )
	{
		return some;
	}

	public void setSome( some some )
	{
		this.some = some;
	}

}
