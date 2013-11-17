
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class row_value_predicand
{

	@Element(required = false)
	private row_value_special_case row_value_special_case;

	@Element(required = false)
	private row_value_constructor_predicand row_value_constructor_predicand;
}
