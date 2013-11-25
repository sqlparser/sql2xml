
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class binary_value_expression
{

	@Element(required = false)
	private binary_concatenation binary_concatenation;

	@Element(required = false)
	private binary_factor binary_factor;

	public binary_concatenation getBinary_concatenation( )
	{
		return binary_concatenation;
	}

	public void setBinary_concatenation(
			binary_concatenation binary_concatenation )
	{
		this.binary_concatenation = binary_concatenation;
	}

	public binary_factor getBinary_factor( )
	{
		return binary_factor;
	}

	public void setBinary_factor( binary_factor binary_factor )
	{
		this.binary_factor = binary_factor;
	}

}
