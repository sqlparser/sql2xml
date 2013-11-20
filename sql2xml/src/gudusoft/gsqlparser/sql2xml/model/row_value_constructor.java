package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class row_value_constructor
{
	@Element(required = false)
	common_value_expression common_value_expression;

	@Element(required = false)
	boolean_value_expression boolean_value_expression;
	
	@Element(required = false)
	explicit_row_value_constructor explicit_row_value_constructor;
}
