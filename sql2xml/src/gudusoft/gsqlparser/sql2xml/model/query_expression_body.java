
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class query_expression_body
{

	@Element(required = false)
	private query_term query_term;

	@Element(required = false)
	private query_expression_body_union query_expression_body_union;

	@Element(required = false)
	private query_expression_body_except query_expression_body_except;

	public query_term getQuery_term( )
	{
		return query_term;
	}

	public void setQuery_term( query_term query_term )
	{
		this.query_term = query_term;
	}

	public query_expression_body_union getQuery_expression_body_union( )
	{
		return query_expression_body_union;
	}

	public void setQuery_expression_body_union(
			query_expression_body_union query_expression_body_union )
	{
		this.query_expression_body_union = query_expression_body_union;
	}

	public query_expression_body_except getQuery_expression_body_except( )
	{
		return query_expression_body_except;
	}

	public void setQuery_expression_body_except(
			query_expression_body_except query_expression_body_except )
	{
		this.query_expression_body_except = query_expression_body_except;
	}

}
