
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class query_expression_body
{

	@Element(required = false)
	private query_term query_term;
	
	@Element(required = false)
	private query_expression_body_union query_expression_body_union;
	
	@Element(required = false)
	private query_expression_body_except query_expression_body_except;
	
}
