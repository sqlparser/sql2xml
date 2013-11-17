
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class query_term
{

	@Element(required = false)
	private query_primary query_primary;
	
	@Element(required = false)
	private query_expression_body_intersect query_expression_body_intersect;
}
