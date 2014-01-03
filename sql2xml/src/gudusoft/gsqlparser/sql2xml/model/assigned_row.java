
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class assigned_row
{

	@Element
	private contextually_typed_row_value_expression contextually_typed_row_value_expression = new contextually_typed_row_value_expression( );

	public contextually_typed_row_value_expression getContextually_typed_row_value_expression( )
	{
		return contextually_typed_row_value_expression;
	}

}
