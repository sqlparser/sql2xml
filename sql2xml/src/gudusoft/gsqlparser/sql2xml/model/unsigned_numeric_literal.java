package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class unsigned_numeric_literal
{
	@Element(required = false)
	private String exact_numeric_literal;
	
	@Element(required = false)
	private String approximate_numeric_literal;
}
