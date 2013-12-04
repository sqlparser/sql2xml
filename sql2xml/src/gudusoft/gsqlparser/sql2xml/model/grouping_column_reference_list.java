
package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;

public class grouping_column_reference_list
{

	@ElementList(entry = "grouping_column_reference", inline = true)
	private List<grouping_column_reference> grouping_column_reference = new ArrayList<grouping_column_reference>( );

	public List<grouping_column_reference> getGrouping_column_reference( )
	{
		return grouping_column_reference;
	}

}
