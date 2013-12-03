
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class aggregate_function_general_set
{

	@Element
	private general_set_function general_set_function = new general_set_function( );

	@Element(required = false)
	private filter_clause filter_clause;

	public general_set_function getGeneral_set_function( )
	{
		return general_set_function;
	}

	public filter_clause getFilter_clause( )
	{
		return filter_clause;
	}

	public void setFilter_clause( filter_clause filter_clause )
	{
		this.filter_clause = filter_clause;
	}
}
