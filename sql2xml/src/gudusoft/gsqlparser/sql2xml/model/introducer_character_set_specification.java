
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class introducer_character_set_specification
{

	@Element
	private introducer introducer = new introducer( );

	@Element
	private character_set_specification character_set_specification = new character_set_specification( );

	public introducer getIntroducer( )
	{
		return introducer;
	}

	public character_set_specification getCharacter_set_specification( )
	{
		return character_set_specification;
	}

}
