
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class query_term
{

	@Element(required = false)
	private query_primary query_primary;

	@Element(required = false)
	private query_expression_body_intersect query_expression_body_intersect;

	public query_primary getQuery_primary( )
	{
		return query_primary;
	}

	public void setQuery_primary( query_primary query_primary )
	{
		this.query_primary = query_primary;
	}

	public query_expression_body_intersect getQuery_expression_body_intersect( )
	{
		return query_expression_body_intersect;
	}

	public void setQuery_expression_body_intersect(
			query_expression_body_intersect query_expression_body_intersect )
	{
		this.query_expression_body_intersect = query_expression_body_intersect;
	}

}
