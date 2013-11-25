package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class absolute_value_expression
{
	@Element
	private String kw_abs = "abs";

	@Element
	private numeric_value_expression numeric_value_expression = new numeric_value_expression( );
}
