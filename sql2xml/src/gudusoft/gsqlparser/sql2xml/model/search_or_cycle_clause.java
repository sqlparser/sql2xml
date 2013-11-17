
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class search_or_cycle_clause
{

	@Element(required = false)
	private search_clause search_clause;

	@Element(required = false)
	private cycle_clause cycle_clause;

	@Element(required = false)
	private search_cycle_clause search_cycle_clause;
}
