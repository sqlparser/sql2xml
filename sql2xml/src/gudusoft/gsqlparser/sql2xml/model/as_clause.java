
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class as_clause
{

	@Element(required = false)
	private String kw_as;

	@Element
	private column_name column_name = new column_name( );

	public String getKw_as( )
	{
		return kw_as;
	}

	public void setKw_as( String kw_as )
	{
		this.kw_as = kw_as;
	}

	public column_name getColumn_name( )
	{
		return column_name;
	}

}
