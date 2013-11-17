package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class unsigned_value_specification
{
	@Element(required = false)
	private unsigned_literal unsigned_literal;
	
	@Element(required = false)
	private general_value_specification general_value_specification;
}
