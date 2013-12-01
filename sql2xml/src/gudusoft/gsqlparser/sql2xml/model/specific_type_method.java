
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class specific_type_method
{

	@Element
	private user_defined_type_value_expression user_defined_type_value_expression = new user_defined_type_value_expression( );

	@Element
	private String kw_specifictype = "specifictype";

	public user_defined_type_value_expression getUser_defined_type_value_expression( )
	{
		return user_defined_type_value_expression;
	}

}
