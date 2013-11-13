
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class character_primary
{

	@Element(required = false)
	private value_expression_primary value_expression_primary;

	@Element(required = false)
	private string_value_function string_value_function;
}
