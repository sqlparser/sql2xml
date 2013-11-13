package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class value_expression
{
	@Element(required = false)
	private common_value_expression common_value_expression;
	
	@Element(required = false)
	private boolean_value_expression boolean_value_expression;
	
	@Element(required = false)
	private row_value_expression row_value_expression;
}
