
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class subquery
{

	@Element
	private query_expression query_expression = new query_expression( );

	public query_expression getQuery_expression( )
	{
		return query_expression;
	}

}
