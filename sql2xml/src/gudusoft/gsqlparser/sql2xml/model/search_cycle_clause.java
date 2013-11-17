package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class search_cycle_clause
{
	@Element
	private search_clause search_clause;
	
	@Element
	private cycle_clause cycle_clause;
}
