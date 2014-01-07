
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class from_subquery
{

	@Element(required = false)
	private insert_column_list insert_column_list;

	@Element(required = false)
	private override_clause override_clause;

	@Element
	private query_expression query_expression = new query_expression( );

	public insert_column_list getInsert_column_list( )
	{
		return insert_column_list;
	}

	public void setInsert_column_list( insert_column_list insert_column_list )
	{
		this.insert_column_list = insert_column_list;
	}

	public override_clause getOverride_clause( )
	{
		return override_clause;
	}

	public void setOverride_clause( override_clause override_clause )
	{
		this.override_clause = override_clause;
	}

	public query_expression getQuery_expression( )
	{
		return query_expression;
	}

}
