
package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;

public class contextually_typed_row_value_expression_list
{

	@ElementList(entry = "contextually_typed_row_value_expression", inline = true)
	private List<contextually_typed_row_value_expression> contextually_typed_row_value_expression = new ArrayList<contextually_typed_row_value_expression>( );

	public List<contextually_typed_row_value_expression> getContextually_typed_row_value_expression( )
	{
		return contextually_typed_row_value_expression;
	}

}
