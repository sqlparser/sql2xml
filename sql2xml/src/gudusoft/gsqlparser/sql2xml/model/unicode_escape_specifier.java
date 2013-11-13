package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class unicode_escape_specifier
{
	@Element(name = "double_quote")
	private double_quote left_double_quote;
	
	@Element
	private String unicode_escape_character;
	
	@Element(name = "double_quote")
	private double_quote right_double_quote;
}
