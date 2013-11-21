
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class partitioned_join_table
{

	@Element
	private table_factor table_factor = new table_factor( );

	@Element
	private partitioned_join_column_reference_list partitioned_join_column_reference_list = new partitioned_join_column_reference_list( );

	public table_factor getTable_factor( )
	{
		return table_factor;
	}

	public partitioned_join_column_reference_list getPartitioned_join_column_reference_list( )
	{
		return partitioned_join_column_reference_list;
	}

}
