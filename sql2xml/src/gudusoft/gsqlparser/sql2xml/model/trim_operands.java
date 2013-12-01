
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class trim_operands
{

	@Element
	private specification_character_from specification_character_from = new specification_character_from( );

	@Element
	private trim_source trim_source = new trim_source( );

	public specification_character_from getSpecification_character_from( )
	{
		return specification_character_from;
	}

	public trim_source getTrim_source( )
	{
		return trim_source;
	}

}
