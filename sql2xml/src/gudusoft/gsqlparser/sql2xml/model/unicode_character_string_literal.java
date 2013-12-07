
package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

public class unicode_character_string_literal
{

	@Element(required = false)
	private introducer_character_set_specification introducer_character_set_specification;

	@Element
	private String ampersand = "&";

	@ElementList(entry = "quoted_character_representation", inline = true)
	private List<quoted_character_representation> quoted_character_representation = new ArrayList<quoted_character_representation>( );

	@Element(required = false)
	private unicode_escape_specifier unicode_escape_specifier;

	public introducer_character_set_specification getIntroducer_character_set_specification( )
	{
		return introducer_character_set_specification;
	}

	public void setIntroducer_character_set_specification(
			introducer_character_set_specification introducer_character_set_specification )
	{
		this.introducer_character_set_specification = introducer_character_set_specification;
	}

	public unicode_escape_specifier getUnicode_escape_specifier( )
	{
		return unicode_escape_specifier;
	}

	public void setUnicode_escape_specifier(
			unicode_escape_specifier unicode_escape_specifier )
	{
		this.unicode_escape_specifier = unicode_escape_specifier;
	}

	public List<quoted_character_representation> getQuoted_character_representation( )
	{
		return quoted_character_representation;
	}

}
