
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class interval_value_expression_minus_interval_term
{

	@Element
	private interval_value_expression_1 interval_value_expression_1 = new interval_value_expression_1( );

	@Element
	private interval_term_1 interval_term_1 = new interval_term_1( );

	public interval_value_expression_1 getInterval_value_expression_1( )
	{
		return interval_value_expression_1;
	}

	public interval_term_1 getInterval_term_1( )
	{
		return interval_term_1;
	}
}
