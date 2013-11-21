
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class joined_table
{

	@Element(required = false)
	private cross_join cross_join;

	@Element(required = false)
	private qualified_join qualified_join;

	@Element(required = false)
	private natural_join natural_join;

	public cross_join getCross_join( )
	{
		return cross_join;
	}

	public void setCross_join( cross_join cross_join )
	{
		this.cross_join = cross_join;
	}

	public qualified_join getQualified_join( )
	{
		return qualified_join;
	}

	public void setQualified_join( qualified_join qualified_join )
	{
		this.qualified_join = qualified_join;
	}

	public natural_join getNatural_join( )
	{
		return natural_join;
	}

	public void setNatural_join( natural_join natural_join )
	{
		this.natural_join = natural_join;
	}

}
