
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class query_primary
{

	@Element(required = false)
	private simple_table simple_table;

	@Element(required = false)
	private query_expression_body query_expression_body;
}
