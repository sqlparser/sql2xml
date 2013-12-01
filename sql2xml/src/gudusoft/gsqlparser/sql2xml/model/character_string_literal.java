
package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

public class character_string_literal
{

	@Element(required = false)
	private introducer_character_set_specification introducer_character_set_specification;

	@ElementList(entry = "quoted_character_representation", inline = true)
	private List<quoted_character_representation> quoted_character_representation = new ArrayList<quoted_character_representation>( );

	public introducer_character_set_specification getIntroducer_character_set_specification( )
	{
		return introducer_character_set_specification;
	}

	public void setIntroducer_character_set_specification(
			introducer_character_set_specification introducer_character_set_specification )
	{
		this.introducer_character_set_specification = introducer_character_set_specification;
	}

	public List<quoted_character_representation> getQuoted_character_representation( )
	{
		return quoted_character_representation;
	}

}
