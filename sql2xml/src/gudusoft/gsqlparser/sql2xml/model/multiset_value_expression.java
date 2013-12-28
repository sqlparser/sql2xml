
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class multiset_value_expression
{

	@Element(required = false)
	private multiset_term multiset_term;

	@Element(required = false)
	private multiset_value_expression_union multiset_value_expression_union;

	@Element(required = false)
	private multiset_value_expression_except multiset_value_expression_except;

	public multiset_term getMultiset_term( )
	{
		return multiset_term;
	}

	public void setMultiset_term( multiset_term multiset_term )
	{
		this.multiset_term = multiset_term;
	}

	public multiset_value_expression_union getMultiset_value_expression_union( )
	{
		return multiset_value_expression_union;
	}

	public void setMultiset_value_expression_union(
			multiset_value_expression_union multiset_value_expression_union )
	{
		this.multiset_value_expression_union = multiset_value_expression_union;
	}

	public multiset_value_expression_except getMultiset_value_expression_except( )
	{
		return multiset_value_expression_except;
	}

	public void setMultiset_value_expression_except(
			multiset_value_expression_except multiset_value_expression_except )
	{
		this.multiset_value_expression_except = multiset_value_expression_except;
	}

}
