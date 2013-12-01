
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class binary_trim_operands
{

	@Element(required = false)
	private trim_specification trim_specification;

	@Element(required = false)
	private trim_octet trim_octet;

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

	public trim_octet getTrim_octet( )
	{
		return trim_octet;
	}

	public void setTrim_octet( trim_octet trim_octet )
	{
		this.trim_octet = trim_octet;
	}

}
