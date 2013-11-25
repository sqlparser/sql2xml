
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class string_value_function
{

	@Element(required = false)
	character_value_function character_value_function;

	@Element(required = false)
	binary_value_function binary_value_function;

	public character_value_function getCharacter_value_function( )
	{
		return character_value_function;
	}

	public void setCharacter_value_function(
			character_value_function character_value_function )
	{
		this.character_value_function = character_value_function;
	}

	public binary_value_function getBinary_value_function( )
	{
		return binary_value_function;
	}

	public void setBinary_value_function(
			binary_value_function binary_value_function )
	{
		this.binary_value_function = binary_value_function;
	}

}
