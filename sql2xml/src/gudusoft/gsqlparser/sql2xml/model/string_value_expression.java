
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class string_value_expression
{

	@Element(required = false)
	private character_value_expression character_value_expression;

	@Element(required = false)
	private binary_value_expression binary_value_expression;

	public character_value_expression getCharacter_value_expression( )
	{
		return character_value_expression;
	}

	public void setCharacter_value_expression(
			character_value_expression character_value_expression )
	{
		this.character_value_expression = character_value_expression;
	}

	public binary_value_expression getBinary_value_expression( )
	{
		return binary_value_expression;
	}

	public void setBinary_value_expression(
			binary_value_expression binary_value_expression )
	{
		this.binary_value_expression = binary_value_expression;
	}

}
