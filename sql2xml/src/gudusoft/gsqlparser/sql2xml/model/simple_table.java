package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class simple_table
{
	@Element(required = false)
	private query_specification query_specification;

	@Element(required = false)
	private table_value_constructor table_value_constructor;
	
	@Element(required = false)
	private explicit_table explicit_table;
}
