
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class occurrence_regex_transliteration_occurrence
{

	@Element
	private String kw_occurrence = "occurrence";

	@Element
	private regex_transliteration_occurrence regex_transliteration_occurrence = new regex_transliteration_occurrence( );

	public regex_transliteration_occurrence getRegex_transliteration_occurrence( )
	{
		return regex_transliteration_occurrence;
	}

}
