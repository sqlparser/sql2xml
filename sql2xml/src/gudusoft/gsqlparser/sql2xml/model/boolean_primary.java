package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class boolean_primary
{
	@Element(required = false)
	private predicate predicate;
	
	@Element(required = false)
	private boolean_predicand boolean_predicand;
}
