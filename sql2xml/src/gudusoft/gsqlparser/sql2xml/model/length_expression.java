
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class length_expression
{

	@Element(required = false)
	private char_length_expression char_length_expression;

	@Element(required = false)
	private octet_length_expression octet_length_expression;

	public char_length_expression getChar_length_expression( )
	{
		return char_length_expression;
	}

	public void setChar_length_expression(
			char_length_expression char_length_expression )
	{
		this.char_length_expression = char_length_expression;
	}

	public octet_length_expression getOctet_length_expression( )
	{
		return octet_length_expression;
	}

	public void setOctet_length_expression(
			octet_length_expression octet_length_expression )
	{
		this.octet_length_expression = octet_length_expression;
	}

}
