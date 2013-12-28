
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class member_predicate_part_2
{

	@Element(required = false)
	private String kw_not;

	@Element
	private String kw_member = "member";

	@Element(required = false)
	private String kw_of;

	@Element
	private multiset_value_expression multiset_value_expression = new multiset_value_expression( );

	public String getKw_not( )
	{
		return kw_not;
	}

	public void setKw_not( String kw_not )
	{
		this.kw_not = kw_not;
	}

	public String getKw_of( )
	{
		return kw_of;
	}

	public void setKw_of( String kw_of )
	{
		this.kw_of = kw_of;
	}

	public multiset_value_expression getMultiset_value_expression( )
	{
		return multiset_value_expression;
	}

}
