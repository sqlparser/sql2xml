
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class regex_position_expression
{

	@Element
	private String kw_position_regex = "position_regex";

	@Element(required = false)
	private regex_position_start_or_after regex_position_start_or_after;

	@Element
	private xquery_pattern xquery_pattern = new xquery_pattern( );

	@Element(required = false)
	private flag_xquery_option_flag flag_xquery_option_flag;

	@Element
	private String kw_in = "in";

	@Element
	private regex_subject_string regex_subject_string = new regex_subject_string( );

	@Element(required = false)
	private from_start_position from_start_position;

	@Element(required = false)
	private using_char_length_units using_char_length_units;

	@Element(required = false)
	private occurrence_regex_occurrence occurrence_regex_occurrence;

	@Element(required = false)
	private group_regex_capture_group group_regex_capture_group;

	public regex_position_start_or_after getRegex_position_start_or_after( )
	{
		return regex_position_start_or_after;
	}

	public void setRegex_position_start_or_after(
			regex_position_start_or_after regex_position_start_or_after )
	{
		this.regex_position_start_or_after = regex_position_start_or_after;
	}

	public flag_xquery_option_flag getFlag_xquery_option_flag( )
	{
		return flag_xquery_option_flag;
	}

	public void setFlag_xquery_option_flag(
			flag_xquery_option_flag flag_xquery_option_flag )
	{
		this.flag_xquery_option_flag = flag_xquery_option_flag;
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

	public occurrence_regex_occurrence getOccurrence_regex_occurrence( )
	{
		return occurrence_regex_occurrence;
	}

	public void setOccurrence_regex_occurrence(
			occurrence_regex_occurrence occurrence_regex_occurrence )
	{
		this.occurrence_regex_occurrence = occurrence_regex_occurrence;
	}

	public group_regex_capture_group getGroup_regex_capture_group( )
	{
		return group_regex_capture_group;
	}

	public void setGroup_regex_capture_group(
			group_regex_capture_group group_regex_capture_group )
	{
		this.group_regex_capture_group = group_regex_capture_group;
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
