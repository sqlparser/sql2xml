
package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;

public class ordinary_grouping_set_list
{

	@ElementList(entry = "ordinary_grouping_set", inline = true)
	private List<ordinary_grouping_set> ordinary_grouping_set = new ArrayList<ordinary_grouping_set>( );

	public List<ordinary_grouping_set> getOrdinary_grouping_set( )
	{
		return ordinary_grouping_set;
	}

}
