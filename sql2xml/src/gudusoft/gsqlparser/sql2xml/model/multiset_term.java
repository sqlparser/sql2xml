
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class multiset_term
{

	@Element(required = false)
	private multiset_primary multiset_primary;

	@Element(required = false)
	private multiset_value_expression_intersect multiset_value_expression_intersect;

	public multiset_primary getMultiset_primary( )
	{
		return multiset_primary;
	}

	public void setMultiset_primary( multiset_primary multiset_primary )
	{
		this.multiset_primary = multiset_primary;
	}

	public multiset_value_expression_intersect getMultiset_value_expression_intersect( )
	{
		return multiset_value_expression_intersect;
	}

	public void setMultiset_value_expression_intersect(
			multiset_value_expression_intersect multiset_value_expression_intersect )
	{
		this.multiset_value_expression_intersect = multiset_value_expression_intersect;
	}

}
