
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class empty_specification
{

	@Element(required = false)
	private String kw_array;

	@Element(required = false)
	private String kw_multiset;

	public String getKw_array( )
	{
		return kw_array;
	}

	public void setKw_array( String kw_array )
	{
		this.kw_array = kw_array;
	}

	public String getKw_multiset( )
	{
		return kw_multiset;
	}

	public void setKw_multiset( String kw_multiset )
	{
		this.kw_multiset = kw_multiset;
	}

}
