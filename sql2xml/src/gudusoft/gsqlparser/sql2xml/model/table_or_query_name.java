package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class table_or_query_name
{
	@Element(required = false)
	private table_name table_name;
	
	@Element(required = false)
	private transition_table_name transition_table_name;
	
	@Element(required = false)
	private query_name query_name;
}
