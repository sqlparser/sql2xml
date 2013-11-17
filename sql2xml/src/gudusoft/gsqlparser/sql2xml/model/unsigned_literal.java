package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class unsigned_literal
{
	@Element(required = false)
	private unsigned_numeric_literal unsigned_numeric_literal;
	
	@Element(required = false)
	private general_literal general_literal;
}
