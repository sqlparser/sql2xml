
package gudusoft.gsqlparser.sql2xml.model;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

public class row_value_constructor_element_list_with_row
{

	@Element
	private String kw_row;

	@ElementList(entry = "row_value_constructor_element", inline = true)
	private List<row_value_constructor_element> row_value_constructor_element;
}
