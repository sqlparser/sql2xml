
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class table_reference
{

	@Element(required = false)
	private table_factor table_factor;

	@Element(required = false)
	private joined_table joined_table;

	public table_factor getTable_factor( )
	{
		return table_factor;
	}

	public void setTable_factor( table_factor table_factor )
	{
		this.table_factor = table_factor;
	}

	public joined_table getJoined_table( )
	{
		return joined_table;
	}

	public void setJoined_table( joined_table joined_table )
	{
		this.joined_table = joined_table;
	}

}
