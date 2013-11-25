
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class octet_length_expression
{

	@Element
	private String kw_octet_length = "octet_length";

	@Element
	private string_value_expression string_value_expression = new string_value_expression( );

	public string_value_expression getString_value_expression( )
	{
		return string_value_expression;
	}

}
