package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class character_transliteration
{
	@Element
	private String kw_translate = "translate";

	@Element
	private character_value_expression character_value_expression = new character_value_expression( );

	@Element
	private String kw_using = "using";

	@Element
	private transliteration_name transliteration_name = new transliteration_name( );
}
