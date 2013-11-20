
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class query_primary
{

	@Element(required = false)
	private simple_table simple_table;

	@Element(required = false)
	private query_expression_body query_expression_body;

	public simple_table getSimple_table( )
	{
		return simple_table;
	}

	public void setSimple_table( simple_table simple_table )
	{
		this.simple_table = simple_table;
	}

	public query_expression_body getQuery_expression_body( )
	{
		return query_expression_body;
	}

	public void setQuery_expression_body(
			query_expression_body query_expression_body )
	{
		this.query_expression_body = query_expression_body;
	}
}
