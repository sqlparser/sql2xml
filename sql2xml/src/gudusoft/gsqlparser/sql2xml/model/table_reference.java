package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class table_reference
{
	@Element(required = false)
	private table_factor table_factor;
	
	@Element(required = false)
	private joined_table joined_table;
}
