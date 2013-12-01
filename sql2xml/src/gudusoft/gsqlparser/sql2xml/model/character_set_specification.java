
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class character_set_specification
{

	@Element(required = false)
	private standard_character_set_name standard_character_set_name;

	@Element(required = false)
	private implementation_defined_character_set_name implementation_defined_character_set_name;

	@Element(required = false)
	private user_defined_character_set_name user_defined_character_set_name;

	public standard_character_set_name getStandard_character_set_name( )
	{
		return standard_character_set_name;
	}

	public void setStandard_character_set_name(
			standard_character_set_name standard_character_set_name )
	{
		this.standard_character_set_name = standard_character_set_name;
	}

	public implementation_defined_character_set_name getImplementation_defined_character_set_name( )
	{
		return implementation_defined_character_set_name;
	}

	public void setImplementation_defined_character_set_name(
			implementation_defined_character_set_name implementation_defined_character_set_name )
	{
		this.implementation_defined_character_set_name = implementation_defined_character_set_name;
	}

	public user_defined_character_set_name getUser_defined_character_set_name( )
	{
		return user_defined_character_set_name;
	}

	public void setUser_defined_character_set_name(
			user_defined_character_set_name user_defined_character_set_name )
	{
		this.user_defined_character_set_name = user_defined_character_set_name;
	}

}
