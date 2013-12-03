
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class aggregate_function_binary_set
{

	@Element
	private binary_set_function binary_set_function = new binary_set_function( );

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

	public binary_set_function getBinary_set_function( )
	{
		return binary_set_function;
	}

}
