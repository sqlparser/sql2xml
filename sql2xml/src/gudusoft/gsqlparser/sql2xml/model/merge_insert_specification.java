
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class merge_insert_specification
{

	@Element
	private String kw_insert = "insert";

	@Element(required = false)
	private insert_column_list insert_column_list;

	@Element(required = false)
	private override_clause override_clause;

	@Element
	private String kw_values = "values";

	@Element
	private merge_insert_value_list merge_insert_value_list = new merge_insert_value_list( );

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

	public merge_insert_value_list getMerge_insert_value_list( )
	{
		return merge_insert_value_list;
	}

}
