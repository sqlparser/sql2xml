
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class check_constraint_definition
{

	@Element
	private String kw_check = "check";

	@Element
	private search_condition search_condition = new search_condition( );

	public search_condition getSearch_condition( )
	{
		return search_condition;
	}

}
