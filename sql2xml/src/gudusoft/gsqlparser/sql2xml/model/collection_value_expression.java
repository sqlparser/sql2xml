
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class collection_value_expression
{

	@Element(required = false)
	private array_value_expression array_value_expression;

	@Element(required = false)
	private multiset_value_expression multiset_value_expression;

	public array_value_expression getArray_value_expression( )
	{
		return array_value_expression;
	}

	public void setArray_value_expression(
			array_value_expression array_value_expression )
	{
		this.array_value_expression = array_value_expression;
	}

	public multiset_value_expression getMultiset_value_expression( )
	{
		return multiset_value_expression;
	}

	public void setMultiset_value_expression(
			multiset_value_expression multiset_value_expression )
	{
		this.multiset_value_expression = multiset_value_expression;
	}

}
