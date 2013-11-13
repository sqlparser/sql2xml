package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class common_value_expression
{
	@Element(required = false)
	private numeric_value_expression numeric_value_expression;
	
	@Element(required = false)
	private string_value_expression string_value_expression;
	
	@Element(required = false)
	private datetime_value_expression datetime_value_expression;
	
	@Element(required = false)
	private interval_value_expression interval_value_expression;
	
	@Element(required = false)
	private user_defined_type_value_expression user_defined_type_value_expression;
	
	@Element(required = false)
	private reference_value_expression reference_value_expression;
	
	@Element(required = false)
	private collection_value_expression collection_value_expression;
}
