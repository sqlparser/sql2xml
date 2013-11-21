
package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;

public class partitioned_join_column_reference_list
{

	@ElementList(entry = "partitioned_join_column_reference", inline = true)
	private List<partitioned_join_column_reference> partitioned_join_column_reference = new ArrayList<partitioned_join_column_reference>( );

	public List<partitioned_join_column_reference> getPartitioned_join_column_reference( )
	{
		return partitioned_join_column_reference;
	}

}
