
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class outer_join_type_with_outer
{

	@Element
	private outer_join_type outer_join_type = new outer_join_type( );

	@Element(required = false)
	private String kw_outer;

	public String getKw_outer( )
	{
		return kw_outer;
	}

	public void setKw_outer( String kw_outer )
	{
		this.kw_outer = kw_outer;
	}

	public outer_join_type getOuter_join_type( )
	{
		return outer_join_type;
	}

}
