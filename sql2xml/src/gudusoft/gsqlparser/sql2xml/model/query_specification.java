
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class query_specification
{

	@Element
	private String kw_select = "select";

	@Element(required = false)
	private set_quantifier set_quantifier;

	@Element
	private select_list select_list = new select_list( );

	@Element
	private table_expression table_expression = new table_expression( );

	public set_quantifier getSet_quantifier( )
	{
		return set_quantifier;
	}

	public void setSet_quantifier( set_quantifier set_quantifier )
	{
		this.set_quantifier = set_quantifier;
	}

	public select_list getSelect_list( )
	{
		return select_list;
	}

	public table_expression getTable_expression( )
	{
		return table_expression;
	}

}
