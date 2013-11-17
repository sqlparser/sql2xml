package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class row_value_constructor_predicand
{
	@Element(required = false)
	private common_value_expression common_value_expression;
	
	@Element(required = false)
	private boolean_predicand boolean_predicand;
	
	@Element(required = false)
	private explicit_row_value_constructor explicit_row_value_constructor;
	
}
