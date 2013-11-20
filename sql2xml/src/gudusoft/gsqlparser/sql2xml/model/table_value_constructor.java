
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class table_value_constructor
{

	@Element
	String kw_values = "values";

	@Element
	row_value_expression_list row_value_expression_list;
}
