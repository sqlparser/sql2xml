
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

	public character_string_literal getCharacter_string_literal( )
	{
		return character_string_literal;
	}

	public void setCharacter_string_literal(
			character_string_literal character_string_literal )
	{
		this.character_string_literal = character_string_literal;
	}

	public national_character_string_literal getNational_character_string_literal( )
	{
		return national_character_string_literal;
	}

	public void setNational_character_string_literal(
			national_character_string_literal national_character_string_literal )
	{
		this.national_character_string_literal = national_character_string_literal;
	}

	public unicode_character_string_literal getUnicode_character_string_literal( )
	{
		return unicode_character_string_literal;
	}

	public void setUnicode_character_string_literal(
			unicode_character_string_literal unicode_character_string_literal )
	{
		this.unicode_character_string_literal = unicode_character_string_literal;
	}

	public String getBinary_string_literal( )
	{
		return binary_string_literal;
	}

	public void setBinary_string_literal( String binary_string_literal )
	{
		this.binary_string_literal = binary_string_literal;
	}

	public datetime_literal getDatetime_literal( )
	{
		return datetime_literal;
	}

	public void setDatetime_literal( datetime_literal datetime_literal )
	{
		this.datetime_literal = datetime_literal;
	}

	public interval_literal getInterval_literal( )
	{
		return interval_literal;
	}

	public void setInterval_literal( interval_literal interval_literal )
	{
		this.interval_literal = interval_literal;
	}

	public String getBoolean_literal( )
	{
		return boolean_literal;
	}

	public void setBoolean_literal( String boolean_literal )
	{
		this.boolean_literal = boolean_literal;
	}

}
