
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class position_expression
{

	@Element(required = false)
	private character_position_expression character_position_expression;

	@Element(required = false)
	private binary_position_expression binary_position_expression;

	public character_position_expression getCharacter_position_expression( )
	{
		return character_position_expression;
	}

	public void setCharacter_position_expression(
			character_position_expression character_position_expression )
	{
		this.character_position_expression = character_position_expression;
	}

	public binary_position_expression getBinary_position_expression( )
	{
		return binary_position_expression;
	}

	public void setBinary_position_expression(
			binary_position_expression binary_position_expression )
	{
		this.binary_position_expression = binary_position_expression;
	}

}
