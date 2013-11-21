
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class table_expression
{

	@Element
	private from_clause from_clause = new from_clause( );

	@Element(required = false)
	private where_clause where_clause;

	@Element(required = false)
	private group_by_clause group_by_clause;

	@Element(required = false)
	private having_clause having_clause;

	@Element(required = false)
	private window_clause window_clause;

	public where_clause getWhere_clause( )
	{
		return where_clause;
	}

	public void setWhere_clause( where_clause where_clause )
	{
		this.where_clause = where_clause;
	}

	public group_by_clause getGroup_by_clause( )
	{
		return group_by_clause;
	}

	public void setGroup_by_clause( group_by_clause group_by_clause )
	{
		this.group_by_clause = group_by_clause;
	}

	public having_clause getHaving_clause( )
	{
		return having_clause;
	}

	public void setHaving_clause( having_clause having_clause )
	{
		this.having_clause = having_clause;
	}

	public window_clause getWindow_clause( )
	{
		return window_clause;
	}

	public void setWindow_clause( window_clause window_clause )
	{
		this.window_clause = window_clause;
	}

	public from_clause getFrom_clause( )
	{
		return from_clause;
	}

}
