package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class joined_table
{
	@Element(required = false)
	private cross_join cross_join;
	
	@Element(required = false)
	private qualified_join qualified_join;
	
	@Element(required = false)
	private natural_join natural_join;
}
