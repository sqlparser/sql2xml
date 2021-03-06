
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class query_expression_body_intersect
{

	@Element
	private query_term query_term = new query_term( );

	@Element
	private String kw_intersect = "intersect";

	@Element(required = false)
	private set_quantifier set_quantifier;

	@Element(required = false)
	private corresponding_spec corresponding_spec;

	@Element
	private query_primary query_primary = new query_primary( );

	public query_term getQuery_term( )
	{
		return query_term;
	}

	public set_quantifier getSet_quantifier( )
	{
		return set_quantifier;
	}

	public void setSet_quantifier( set_quantifier set_quantifier )
	{
		this.set_quantifier = set_quantifier;
	}

	public corresponding_spec getCorresponding_spec( )
	{
		return corresponding_spec;
	}

	public void setCorresponding_spec( corresponding_spec corresponding_spec )
	{
		this.corresponding_spec = corresponding_spec;
	}

	public query_primary getQuery_primary( )
	{
		return query_primary;
	}

}
