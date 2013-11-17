package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class general_literal
{
	@Element(required = false)
	private character_string_literal character_string_literal;
	
	@Element(required = false)
	private national_character_string_literal national_character_string_literal;
	
	@Element(required = false)
	private unicode_character_string_literal unicode_character_string_literal;
	
	@Element(required = false)
	private String binary_string_literal;
	
	@Element(required = false)
	private datetime_literal datetime_literal;
	
	@Element(required = false)
	private interval_literal interval_literal;
	
	@Element(required = false)
	private String boolean_literal;
}
