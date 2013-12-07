
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class join_type
{

	@Element(required = false)
	private String kw_inner;

	@Element(required = false)
	private outer_join_type_with_outer outer_join_type_with_outer;

	public outer_join_type_with_outer getOuter_join_type_with_outer( )
	{
		return outer_join_type_with_outer;
	}

	public void setOuter_join_type_with_outer(
			outer_join_type_with_outer outer_join_type_with_outer )
	{
		this.outer_join_type_with_outer = outer_join_type_with_outer;
	}

	public String getKw_inner( )
	{
		return kw_inner;
	}

	public void setKw_inner( String kw_inner )
	{
		this.kw_inner = kw_inner;
	}

}
