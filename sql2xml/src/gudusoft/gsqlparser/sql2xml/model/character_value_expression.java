package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class character_value_expression
{
	@Element(required = false)
	private concatenation concatenation;
	
	@Element(required = false)
	private character_factor character_factor;
}
