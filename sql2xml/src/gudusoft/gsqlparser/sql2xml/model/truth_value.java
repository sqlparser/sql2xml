
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class truth_value
{

	@Element(required = false)
	private String kw_true;

	@Element(required = false)
	private String kw_false;

	@Element(required = false)
	private String kw_unknown;

	public String getKw_true( )
	{
		return kw_true;
	}

	public void setKw_true( String kw_true )
	{
		this.kw_true = kw_true;
	}

	public String getKw_false( )
	{
		return kw_false;
	}

	public void setKw_false( String kw_false )
	{
		this.kw_false = kw_false;
	}

	public String getKw_unknown( )
	{
		return kw_unknown;
	}

	public void setKw_unknown( String kw_unknown )
	{
		this.kw_unknown = kw_unknown;
	}

}
