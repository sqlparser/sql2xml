package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class numeric_primary
{
	@Element(required = false)
	private value_expression_primary value_expression_primary;
	
	@Element(required = false)
	private numeric_value_function numeric_value_function;
}
