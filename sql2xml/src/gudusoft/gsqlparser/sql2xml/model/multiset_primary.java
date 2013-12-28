
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class multiset_primary
{

	@Element(required = false)
	private multiset_value_function multiset_value_function;

	@Element(required = false)
	private value_expression_primary value_expression_primary;

	public multiset_value_function getMultiset_value_function( )
	{
		return multiset_value_function;
	}

	public void setMultiset_value_function(
			multiset_value_function multiset_value_function )
	{
		this.multiset_value_function = multiset_value_function;
	}

	public value_expression_primary getValue_expression_primary( )
	{
		return value_expression_primary;
	}

	public void setValue_expression_primary(
			value_expression_primary value_expression_primary )
	{
		this.value_expression_primary = value_expression_primary;
	}

}
