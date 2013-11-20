
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class table_row_value_expression
{

	@Element(required = false)
	row_value_special_case row_value_special_case;

	@Element(required = false)
	row_value_constructor row_value_constructor;
}
