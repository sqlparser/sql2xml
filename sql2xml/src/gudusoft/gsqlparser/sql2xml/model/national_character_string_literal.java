
package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;

public class national_character_string_literal
{

	@ElementList(entry = "quoted_character_representation", inline = true)
	private List<quoted_character_representation> quoted_character_representation = new ArrayList<quoted_character_representation>( );

	public List<quoted_character_representation> getQuoted_character_representation( )
	{
		return quoted_character_representation;
	}

}
