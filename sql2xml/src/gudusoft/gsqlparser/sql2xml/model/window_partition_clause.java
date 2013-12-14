
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class window_partition_clause
{

	@Element
	private String kw_partition = "partition";

	@Element
	private String kw_by = "by";

	@Element
	private window_partition_column_reference_list window_partition_column_reference_list = new window_partition_column_reference_list( );

	public window_partition_column_reference_list getWindow_partition_column_reference_list( )
	{
		return window_partition_column_reference_list;
	}

}
