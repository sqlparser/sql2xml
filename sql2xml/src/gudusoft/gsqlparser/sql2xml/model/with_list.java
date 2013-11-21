
package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;

public class with_list
{

	@ElementList(entry = "with_list_element", inline = true)
	private List<with_list_element> with_list_element = new ArrayList<with_list_element>( );

	public List<with_list_element> getWith_list_element( )
	{
		return with_list_element;
	}

}
