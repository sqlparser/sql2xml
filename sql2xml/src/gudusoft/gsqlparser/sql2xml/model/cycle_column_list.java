
package gudusoft.gsqlparser.sql2xml.model;

import java.util.List;

import org.simpleframework.xml.ElementList;

public class cycle_column_list
{

	@ElementList(entry = "cycle_column", inline = true)
	private List<cycle_column> cycle_column;

}
