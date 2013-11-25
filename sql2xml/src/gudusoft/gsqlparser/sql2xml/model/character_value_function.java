
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class character_value_function
{

	@Element(required = false)
	private character_substring_function character_substring_function;

	@Element(required = false)
	private regular_expression_substring_function regular_expression_substring_function;

	@Element(required = false)
	private regex_substring_function regex_substring_function;

	@Element(required = false)
	private fold fold;

	@Element(required = false)
	private transcoding transcoding;

	@Element(required = false)
	private character_transliteration character_transliteration;

	@Element(required = false)
	private regex_transliteration regex_transliteration;

	@Element(required = false)
	private trim_function trim_function;

	@Element(required = false)
	private character_overlay_function character_overlay_function;

	@Element(required = false)
	private normalize_function normalize_function;

	@Element(required = false)
	private specific_type_method specific_type_method;

	public character_substring_function getCharacter_substring_function( )
	{
		return character_substring_function;
	}

	public void setCharacter_substring_function(
			character_substring_function character_substring_function )
	{
		this.character_substring_function = character_substring_function;
	}

	public regular_expression_substring_function getRegular_expression_substring_function( )
	{
		return regular_expression_substring_function;
	}

	public void setRegular_expression_substring_function(
			regular_expression_substring_function regular_expression_substring_function )
	{
		this.regular_expression_substring_function = regular_expression_substring_function;
	}

	public regex_substring_function getRegex_substring_function( )
	{
		return regex_substring_function;
	}

	public void setRegex_substring_function(
			regex_substring_function regex_substring_function )
	{
		this.regex_substring_function = regex_substring_function;
	}

	public fold getFold( )
	{
		return fold;
	}

	public void setFold( fold fold )
	{
		this.fold = fold;
	}

	public transcoding getTranscoding( )
	{
		return transcoding;
	}

	public void setTranscoding( transcoding transcoding )
	{
		this.transcoding = transcoding;
	}

	public character_transliteration getCharacter_transliteration( )
	{
		return character_transliteration;
	}

	public void setCharacter_transliteration(
			character_transliteration character_transliteration )
	{
		this.character_transliteration = character_transliteration;
	}

	public regex_transliteration getRegex_transliteration( )
	{
		return regex_transliteration;
	}

	public void setRegex_transliteration(
			regex_transliteration regex_transliteration )
	{
		this.regex_transliteration = regex_transliteration;
	}

	public trim_function getTrim_function( )
	{
		return trim_function;
	}

	public void setTrim_function( trim_function trim_function )
	{
		this.trim_function = trim_function;
	}

	public character_overlay_function getCharacter_overlay_function( )
	{
		return character_overlay_function;
	}

	public void setCharacter_overlay_function(
			character_overlay_function character_overlay_function )
	{
		this.character_overlay_function = character_overlay_function;
	}

	public normalize_function getNormalize_function( )
	{
		return normalize_function;
	}

	public void setNormalize_function( normalize_function normalize_function )
	{
		this.normalize_function = normalize_function;
	}

	public specific_type_method getSpecific_type_method( )
	{
		return specific_type_method;
	}

	public void setSpecific_type_method(
			specific_type_method specific_type_method )
	{
		this.specific_type_method = specific_type_method;
	}

}
