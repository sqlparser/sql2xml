
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class cursor_specification
{

	@Element
	private query_expression query_expression;

	@Element(required = false)
	private order_by_clause order_by_clause;

	@Element(required = false)
	private updatability_clause updatability_clause;
}
