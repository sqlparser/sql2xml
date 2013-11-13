package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;


public class from_clause
{
	@Element
	private String kw_from;
	
	@ElementList(inline=true)
	private table_reference table_reference;
}
