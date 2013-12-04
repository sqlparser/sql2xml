
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class group_by_clause
{

	@Element
	private String kw_group = "group";

	@Element
	private String kw_by = "by";

	@Element(required = false)
	private set_quantifier set_quantifier;

	@Element
	private grouping_element_list grouping_element_list = new grouping_element_list( );

	public set_quantifier getSet_quantifier( )
	{
		return set_quantifier;
	}

	public void setSet_quantifier( set_quantifier set_quantifier )
	{
		this.set_quantifier = set_quantifier;
	}

	public grouping_element_list getGrouping_element_list( )
	{
		return grouping_element_list;
	}

}
