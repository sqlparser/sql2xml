
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class regex_transliteration
{

	@Element
	private String kw_translate_regex = "translate_regex";

	@Element
	private xquery_pattern xquery_pattern = new xquery_pattern( );

	@Element(required = false)
	private flag_xquery_option_flag flag_xquery_option_flag;

	@Element
	private String kw_in = "in";

	@Element
	private regex_subject_string regex_subject_string = new regex_subject_string( );

	@Element(required = false)
	private with_xquery_replacement_string with_xquery_replacement_string;

	@Element(required = false)
	private from_start_position from_start_position;

	@Element(required = false)
	private using_char_length_units using_char_length_units;

	@Element(required = false)
	private occurrence_regex_transliteration_occurrence occurrence_regex_transliteration_occurrence;

	public flag_xquery_option_flag getFlag_xquery_option_flag( )
	{
		return flag_xquery_option_flag;
	}

	public void setFlag_xquery_option_flag(
			flag_xquery_option_flag flag_xquery_option_flag )
	{
		this.flag_xquery_option_flag = flag_xquery_option_flag;
	}

	public with_xquery_replacement_string getWith_xquery_replacement_string( )
	{
		return with_xquery_replacement_string;
	}

	public void setWith_xquery_replacement_string(
			with_xquery_replacement_string with_xquery_replacement_string )
	{
		this.with_xquery_replacement_string = with_xquery_replacement_string;
	}

	public from_start_position getFrom_start_position( )
	{
		return from_start_position;
	}

	public void setFrom_start_position( from_start_position from_start_position )
	{
		this.from_start_position = from_start_position;
	}

	public using_char_length_units getUsing_char_length_units( )
	{
		return using_char_length_units;
	}

	public void setUsing_char_length_units(
			using_char_length_units using_char_length_units )
	{
		this.using_char_length_units = using_char_length_units;
	}

	public occurrence_regex_transliteration_occurrence getOccurrence_regex_transliteration_occurrence( )
	{
		return occurrence_regex_transliteration_occurrence;
	}

	public void setOccurrence_regex_transliteration_occurrence(
			occurrence_regex_transliteration_occurrence occurrence_regex_transliteration_occurrence )
	{
		this.occurrence_regex_transliteration_occurrence = occurrence_regex_transliteration_occurrence;
	}

	public xquery_pattern getXquery_pattern( )
	{
		return xquery_pattern;
	}

	public regex_subject_string getRegex_subject_string( )
	{
		return regex_subject_string;
	}

}
