
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class multiset_value_expression_intersect
{

	@Element
	private multiset_value_expression multiset_value_expression = new multiset_value_expression( );

	@Element
	private set_quantifier set_quantifier;

	@Element
	private multiset_term multiset_term = new multiset_term( );

	public set_quantifier getSet_quantifier( )
	{
		return set_quantifier;
	}

	public void setSet_quantifier( set_quantifier set_quantifier )
	{
		this.set_quantifier = set_quantifier;
	}

	public multiset_value_expression getMultiset_value_expression( )
	{
		return multiset_value_expression;
	}

	public multiset_term getMultiset_term( )
	{
		return multiset_term;
	}
}
