
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class in_predicate_value
{

	@Element(required = false)
	private table_subquery table_subquery;

	@Element(required = false)
	private in_value_list in_value_list;

	public table_subquery getTable_subquery( )
	{
		return table_subquery;
	}

	public void setTable_subquery( table_subquery table_subquery )
	{
		this.table_subquery = table_subquery;
	}

	public in_value_list getIn_value_list( )
	{
		return in_value_list;
	}

	public void setIn_value_list( in_value_list in_value_list )
	{
		this.in_value_list = in_value_list;
	}

}
