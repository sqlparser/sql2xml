
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class simple_table
{

	@Element(required = false)
	private query_specification query_specification;

	@Element(required = false)
	private table_value_constructor table_value_constructor;

	@Element(required = false)
	private explicit_table explicit_table;

	public query_specification getQuery_specification( )
	{
		return query_specification;
	}

	public void setQuery_specification( query_specification query_specification )
	{
		this.query_specification = query_specification;
	}

	public table_value_constructor getTable_value_constructor( )
	{
		return table_value_constructor;
	}

	public void setTable_value_constructor(
			table_value_constructor table_value_constructor )
	{
		this.table_value_constructor = table_value_constructor;
	}

	public explicit_table getExplicit_table( )
	{
		return explicit_table;
	}

	public void setExplicit_table( explicit_table explicit_table )
	{
		this.explicit_table = explicit_table;
	}
}
