
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class table_definition
{

	@Element
	private String kw_create = "create";

	@Element(required = false)
	private table_scope table_scope;

	@Element
	private String kw_table = "table";

	@Element
	private table_name table_name = new table_name( );

	@Element
	private table_contents_source table_contents_source = new table_contents_source( );

	public table_name getTable_name( )
	{
		return table_name;
	}

	@Element(required = false)
	private on_commit_rows on_commit_rows;

	public table_scope getTable_scope( )
	{
		return table_scope;
	}

	public void setTable_scope( table_scope table_scope )
	{
		this.table_scope = table_scope;
	}

	public on_commit_rows getOn_commit_rows( )
	{
		return on_commit_rows;
	}

	public void setOn_commit_rows( on_commit_rows on_commit_rows )
	{
		this.on_commit_rows = on_commit_rows;
	}

	public table_contents_source getTable_contents_source( )
	{
		return table_contents_source;
	}

}
