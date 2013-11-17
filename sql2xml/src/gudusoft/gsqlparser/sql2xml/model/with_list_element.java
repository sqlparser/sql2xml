package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class with_list_element
{
	@Element
	private query_name query_name;
	
	@Element(required = false)
	private with_column_list with_column_list ;
	
	@Element
	private String kw_as;
	
	@Element
	private query_expression query_expression;
	
	@Element(required = false)
	private search_or_cycle_clause search_or_cycle_clause;
}
