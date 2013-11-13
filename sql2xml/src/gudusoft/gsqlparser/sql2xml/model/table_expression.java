
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class table_expression
{

	@Element
	private from_clause from_clause;

	@Element(required = false)
	private where_clause where_clause;
	
	@Element(required = false)
	private group_by_clause group_by_clause;
	
	@Element(required = false)
	private having_clause having_clause;
	
	@Element(required = false)
	private window_clause window_clause;
}
