
package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;

public class grouping_element_list
{

	@ElementList(entry = "grouping_element", inline = true)
	private List<grouping_element> grouping_element = new ArrayList<grouping_element>( );

	public List<grouping_element> getGrouping_element( )
	{
		return grouping_element;
	}

}
