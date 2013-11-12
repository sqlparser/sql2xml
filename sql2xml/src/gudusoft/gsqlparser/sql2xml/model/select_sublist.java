package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class select_sublist
{
	@Element(required = false)
	private derived_column derived_column;
	
	@Element(required = false)
	private qualified_asterisk qualified_asterisk;
}
