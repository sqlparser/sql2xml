
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class contextually_typed_table_value_constructor
{

	@Element
	private String kw_values = "values";

	@Element
	private contextually_typed_row_value_expression_list contextually_typed_row_value_expression_list = new contextually_typed_row_value_expression_list( );

	public contextually_typed_row_value_expression_list getContextually_typed_row_value_expression_list( )
	{
		return contextually_typed_row_value_expression_list;
	}

}
