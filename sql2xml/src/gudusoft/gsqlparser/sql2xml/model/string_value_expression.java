package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class string_value_expression
{
	@Element(required = false)
	private character_value_expression character_value_expression;
	
	@Element(required = false)
	private binary_value_expression binary_value_expression;
}
