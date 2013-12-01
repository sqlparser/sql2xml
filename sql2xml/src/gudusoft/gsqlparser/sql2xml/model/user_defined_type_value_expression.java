
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class user_defined_type_value_expression
{

	@Element
	value_expression_primary value_expression_primary = new value_expression_primary( );

	public value_expression_primary getValue_expression_primary( )
	{
		return value_expression_primary;
	}

}
