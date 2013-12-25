
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class asymmetric_symmetric
{

	@Element(required = false)
	private String kw_asymmetric;

	@Element(required = false)
	private String kw_symmetric;

	public String getKw_asymmetric( )
	{
		return kw_asymmetric;
	}

	public void setKw_asymmetric( String kw_asymmetric )
	{
		this.kw_asymmetric = kw_asymmetric;
	}

	public String getKw_symmetric( )
	{
		return kw_symmetric;
	}

	public void setKw_symmetric( String kw_symmetric )
	{
		this.kw_symmetric = kw_symmetric;
	}

}
