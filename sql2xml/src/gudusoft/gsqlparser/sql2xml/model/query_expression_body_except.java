
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class query_expression_body_except
{

	@Element
	private query_expression_body query_expression_body = new query_expression_body( );

	@Element
	private String kw_except = "except";

	@Element(required = false)
	private set_quantifier set_quantifier;

	@Element(required = false)
	private corresponding_spec corresponding_spec;

	@Element
	private query_term query_term = new query_term( );

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

	public query_expression_body getQuery_expression_body( )
	{
		return query_expression_body;
	}

	public query_term getQuery_term( )
	{
		return query_term;
	}

}
