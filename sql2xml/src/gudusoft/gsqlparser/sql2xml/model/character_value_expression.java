
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class character_value_expression
{

	@Element(required = false)
	private concatenation concatenation;

	@Element(required = false)
	private character_factor character_factor;

	public concatenation getConcatenation( )
	{
		return concatenation;
	}

	public void setConcatenation( concatenation concatenation )
	{
		this.concatenation = concatenation;
	}

	public character_factor getCharacter_factor( )
	{
		return character_factor;
	}

	public void setCharacter_factor( character_factor character_factor )
	{
		this.character_factor = character_factor;
	}

}
