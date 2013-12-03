
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class aggregate_function_ordered_set
{

	@Element
	private ordered_set_function ordered_set_function = new ordered_set_function( );

	@Element(required = false)
	private filter_clause filter_clause;

	public filter_clause getFilter_clause( )
	{
		return filter_clause;
	}

	public void setFilter_clause( filter_clause filter_clause )
	{
		this.filter_clause = filter_clause;
	}

	public ordered_set_function getOrdered_set_function( )
	{
		return ordered_set_function;
	}

}
