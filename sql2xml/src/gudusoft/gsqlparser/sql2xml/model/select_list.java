
package gudusoft.gsqlparser.sql2xml.model;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

public class select_list
{

	@Element(required = false)
	private String asterisk;

	@ElementList(entry = "select_sublist", inline = true, required = false)
	private List<select_sublist> select_sublist;

}
