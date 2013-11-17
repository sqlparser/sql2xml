package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class unicode_delimited_identifier
{
	@Element
	private String ampersand;
	
	@Element(name = "double_quote")
	private String left_double_quote;
	
	@Element
	private String unicode_delimiter_body;
	
	@Element(name = "double_quote")
	private String right_double_quote;
	
	@Element(required = false)
	private unicode_escape_specifier unicode_escape_specifier;
}
