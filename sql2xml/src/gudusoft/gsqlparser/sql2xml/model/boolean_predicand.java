package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class boolean_predicand
{
	@Element(required = false)
	private parenthesized_boolean_value_expression parenthesized_boolean_value_expression;
	
	@Element(required = false)
	private nonparenthesized_value_expression_primary nonparenthesized_value_expression_primary;
}
