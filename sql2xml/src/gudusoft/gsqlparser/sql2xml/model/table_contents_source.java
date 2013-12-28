
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class table_contents_source
{

	@Element(required = false)
	private table_element_list table_element_list;

	@Element(required = false)
	private typed_table_clause typed_table_clause;

	@Element(required = false)
	private as_subquery_clause as_subquery_clause;

	public table_element_list getTable_element_list( )
	{
		return table_element_list;
	}

	public void setTable_element_list( table_element_list table_element_list )
	{
		this.table_element_list = table_element_list;
	}

	public typed_table_clause getTyped_table_clause( )
	{
		return typed_table_clause;
	}

	public void setTyped_table_clause( typed_table_clause typed_table_clause )
	{
		this.typed_table_clause = typed_table_clause;
	}

	public as_subquery_clause getAs_subquery_clause( )
	{
		return as_subquery_clause;
	}

	public void setAs_subquery_clause( as_subquery_clause as_subquery_clause )
	{
		this.as_subquery_clause = as_subquery_clause;
	}

}
