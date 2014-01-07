
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class from_constructor
{

	@Element(required = false)
	private insert_column_list insert_column_list;

	@Element(required = false)
	private override_clause override_clause;

	@Element
	private contextually_typed_table_value_constructor contextually_typed_table_value_constructor = new contextually_typed_table_value_constructor( );

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

	public contextually_typed_table_value_constructor getContextually_typed_table_value_constructor( )
	{
		return contextually_typed_table_value_constructor;
	}

}
