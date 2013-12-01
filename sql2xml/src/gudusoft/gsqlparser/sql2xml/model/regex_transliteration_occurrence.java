
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class regex_transliteration_occurrence
{

	@Element(required = false)
	private regex_occurrence regex_occurrence;

	@Element(required = false)
	private String kw_all;

	public regex_occurrence getRegex_occurrence( )
	{
		return regex_occurrence;
	}

	public void setRegex_occurrence( regex_occurrence regex_occurrence )
	{
		this.regex_occurrence = regex_occurrence;
	}

	public String getKw_all( )
	{
		return kw_all;
	}

	public void setKw_all( String kw_all )
	{
		this.kw_all = kw_all;
	}

}
