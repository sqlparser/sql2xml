package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class parenthesized_joined_table
{
	@Element(required = false)
	private joined_table joined_table;
	
	@Element(required = false)
	private parenthesized_joined_table parenthesized_joined_table;
}
