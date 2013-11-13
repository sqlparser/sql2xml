package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class derived_column
{
	@Element
	private value_expression value_expression;
	
	@Element(required = false)
	private as_clause as_clause;
}
