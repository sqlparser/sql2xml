
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class array_concatenation
{

	@Element
	private array_value_expression_1 array_value_expression_1 = new array_value_expression_1( );

	@Element
	private String concatenation_operator = "||";

	@Element
	private array_primary array_primary = new array_primary( );

	public array_value_expression_1 getArray_value_expression_1( )
	{
		return array_value_expression_1;
	}

	public array_primary getArray_primary( )
	{
		return array_primary;
	}

}
