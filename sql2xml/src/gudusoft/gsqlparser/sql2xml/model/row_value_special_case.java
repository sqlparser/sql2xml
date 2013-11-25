
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class row_value_special_case
{

	@Element
	private nonparenthesized_value_expression_primary nonparenthesized_value_expression_primary = new nonparenthesized_value_expression_primary( );

	public nonparenthesized_value_expression_primary getNonparenthesized_value_expression_primary( )
	{
		return nonparenthesized_value_expression_primary;
	}

}
