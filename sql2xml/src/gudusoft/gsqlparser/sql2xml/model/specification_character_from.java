
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class specification_character_from
{

	@Element(required = false)
	private trim_specification trim_specification;

	@Element(required = false)
	private trim_character trim_character;

	@Element
	private String kw_from = "from";

	public trim_specification getTrim_specification( )
	{
		return trim_specification;
	}

	public void setTrim_specification( trim_specification trim_specification )
	{
		this.trim_specification = trim_specification;
	}

	public trim_character getTrim_character( )
	{
		return trim_character;
	}

	public void setTrim_character( trim_character trim_character )
	{
		this.trim_character = trim_character;
	}

}
