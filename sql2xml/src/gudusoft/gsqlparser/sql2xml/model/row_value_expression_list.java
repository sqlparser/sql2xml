
package gudusoft.gsqlparser.sql2xml.model;

import java.util.List;

import org.simpleframework.xml.ElementList;

public class row_value_expression_list
{

	@ElementList(entry = "table_row_value_expression", inline = true)
	private List<table_row_value_expression> table_row_value_expression;
}
