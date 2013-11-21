
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class with_list_element
{

	@Element
	private query_name query_name = new query_name( );

	@Element(required = false)
	private with_column_list with_column_list;

	@Element
	private String kw_as = "as";

	@Element
	private query_expression query_expression = new query_expression( );

	@Element(required = false)
	private search_or_cycle_clause search_or_cycle_clause;

	public with_column_list getWith_column_list( )
	{
		return with_column_list;
	}

	public void setWith_column_list( with_column_list with_column_list )
	{
		this.with_column_list = with_column_list;
	}

	public search_or_cycle_clause getSearch_or_cycle_clause( )
	{
		return search_or_cycle_clause;
	}

	public void setSearch_or_cycle_clause(
			search_or_cycle_clause search_or_cycle_clause )
	{
		this.search_or_cycle_clause = search_or_cycle_clause;
	}

	public query_name getQuery_name( )
	{
		return query_name;
	}

	public query_expression getQuery_expression( )
	{
		return query_expression;
	}

}
