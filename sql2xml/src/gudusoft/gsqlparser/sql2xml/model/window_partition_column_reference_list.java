
package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;

public class window_partition_column_reference_list
{

	@ElementList(entry = "window_partition_column_reference", inline = true)
	private List<window_partition_column_reference> window_partition_column_reference = new ArrayList<window_partition_column_reference>( );

	public List<window_partition_column_reference> getWindow_partition_column_reference( )
	{
		return window_partition_column_reference;
	}

}
