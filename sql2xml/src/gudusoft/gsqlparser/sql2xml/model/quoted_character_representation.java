
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Text;

public class quoted_character_representation
{
	@Path("quote[1]")
	@Text
	private String leftQuote = "'";

	@Element(required = false)
	private String character_representation;

	@Path("quote[2]")
	@Text
	private String rightQuote = "'";

	public String getCharacter_representation( )
	{
		return character_representation;
	}

	public void setCharacter_representation( String character_representation )
	{
		this.character_representation = character_representation;
	}

}
