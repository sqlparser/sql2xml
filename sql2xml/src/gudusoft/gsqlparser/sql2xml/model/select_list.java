
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class select_list
{

	@Element(required = false)
	private String asterisk;
	
	@Element(required = false)
	private select_sublist select_sublist;
	
}
