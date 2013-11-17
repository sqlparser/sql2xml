package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class where_clause
{
	@Element
	private String kw_where;
	
	@Element
	private search_condition search_condition;
}
