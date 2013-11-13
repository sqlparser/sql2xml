
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class value_expression_primary
{

	@Element(required = false)
	private parenthesized_value_expression parenthesized_value_expression;

	@Element(required = false)
	private nonparenthesized_value_expression_primary nonparenthesized_value_expression_primary;
}
