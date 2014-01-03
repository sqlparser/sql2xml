
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class target_table
{

	@Element(required = false)
	private table_name table_name;

	@Element(required = false)
	private only_table_name only_table_name;

	public table_name getTable_name( )
	{
		return table_name;
	}

	public void setTable_name( table_name table_name )
	{
		this.table_name = table_name;
	}

	public only_table_name getOnly_table_name( )
	{
		return only_table_name;
	}

	public void setOnly_table_name( only_table_name only_table_name )
	{
		this.only_table_name = only_table_name;
	}

}
