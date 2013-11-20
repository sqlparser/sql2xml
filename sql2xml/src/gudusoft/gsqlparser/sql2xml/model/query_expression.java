
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class query_expression
{

	@Element(required = false)
	private with_clause with_clause;

	@Element
	private query_expression_body query_expression_body;

	public with_clause getWith_clause( )
	{
		return with_clause;
	}

	public void setWith_clause( with_clause with_clause )
	{
		this.with_clause = with_clause;
	}

	public query_expression_body getQuery_expression_body( )
	{
		return query_expression_body;
	}

	public void setQuery_expression_body(
			query_expression_body query_expression_body )
	{
		this.query_expression_body = query_expression_body;
	}
}
