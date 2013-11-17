
package gudusoft.gsqlparser.sql2xml.model;

import java.util.List;

import org.simpleframework.xml.ElementList;

public class with_list
{

	@ElementList(entry = "with_list_element", inline = true)
	private List<with_list_element> with_list_element;
}
