
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class table_reference_or_partitioned_join_table
{

	@Element(required = false)
	private table_reference table_reference;

	@Element(required = false)
	private partitioned_join_table partitioned_join_table;

	public table_reference getTable_reference( )
	{
		return table_reference;
	}

	public void setTable_reference( table_reference table_reference )
	{
		this.table_reference = table_reference;
	}

	public partitioned_join_table getPartitioned_join_table( )
	{
		return partitioned_join_table;
	}

	public void setPartitioned_join_table(
			partitioned_join_table partitioned_join_table )
	{
		this.partitioned_join_table = partitioned_join_table;
	}

}
