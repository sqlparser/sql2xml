
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class with_clause
{

	@Element
	private String kw_with = "with";

	@Element(required = false)
	private String kw_recursive;

	@Element
	private with_list with_list = new with_list( );

	public String getKw_recursive( )
	{
		return kw_recursive;
	}

	public void setKw_recursive( String kw_recursive )
	{
		this.kw_recursive = kw_recursive;
	}

	public with_list getWith_list( )
	{
		return with_list;
	}

}
