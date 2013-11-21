
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class cursor_specification
{

	@Element
	private query_expression query_expression = new query_expression( );

	@Element(required = false)
	private order_by_clause order_by_clause;

	@Element(required = false)
	private updatability_clause updatability_clause;

	public query_expression getQuery_expression( )
	{
		return query_expression;
	}

	public order_by_clause getOrder_by_clause( )
	{
		return order_by_clause;
	}

	public void setOrder_by_clause( order_by_clause order_by_clause )
	{
		this.order_by_clause = order_by_clause;
	}

	public updatability_clause getUpdatability_clause( )
	{
		return updatability_clause;
	}

	public void setUpdatability_clause( updatability_clause updatability_clause )
	{
		this.updatability_clause = updatability_clause;
	}
}
