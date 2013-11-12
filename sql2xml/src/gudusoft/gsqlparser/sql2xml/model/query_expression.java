
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class query_expression
{

	@Element(required = false)
	private with_clause with_clause;

	@Element
	private query_expression_body query_expression_body;
}
