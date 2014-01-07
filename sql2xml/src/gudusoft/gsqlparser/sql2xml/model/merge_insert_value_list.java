
package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;

public class merge_insert_value_list
{

	@ElementList(entry = "merge_insert_value_element", inline = true)
	private List<merge_insert_value_element> merge_insert_value_element = new ArrayList<merge_insert_value_element>( );

	public List<merge_insert_value_element> getMerge_insert_value_element( )
	{
		return merge_insert_value_element;
	}

}
