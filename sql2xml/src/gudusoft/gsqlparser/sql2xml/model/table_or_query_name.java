
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class table_or_query_name
{

	@Element(required = false)
	private table_name table_name;

	@Element(required = false)
	private transition_table_name transition_table_name;

	@Element(required = false)
	private query_name query_name;

	public table_name getTable_name( )
	{
		return table_name;
	}

	public void setTable_name( table_name table_name )
	{
		this.table_name = table_name;
	}

	public transition_table_name getTransition_table_name( )
	{
		return transition_table_name;
	}

	public void setTransition_table_name(
			transition_table_name transition_table_name )
	{
		this.transition_table_name = transition_table_name;
	}

	public query_name getQuery_name( )
	{
		return query_name;
	}

	public void setQuery_name( query_name query_name )
	{
		this.query_name = query_name;
	}

}
