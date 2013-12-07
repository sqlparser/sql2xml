
package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;

public class in_value_list
{

	@ElementList(entry = "row_value_expression", inline = true)
	private List<row_value_expression> row_value_expression = new ArrayList<row_value_expression>( );

	public List<row_value_expression> getRow_value_expression( )
	{
		return row_value_expression;
	}

}
