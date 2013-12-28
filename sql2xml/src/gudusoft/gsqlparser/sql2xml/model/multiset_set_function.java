
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class multiset_set_function
{

	@Element
	private String kw_set = "set";

	@Element
	private multiset_value_expression multiset_value_expression = new multiset_value_expression( );

	public multiset_value_expression getMultiset_value_expression( )
	{
		return multiset_value_expression;
	}

}
