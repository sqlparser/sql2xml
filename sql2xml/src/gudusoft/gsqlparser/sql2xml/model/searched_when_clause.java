
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class searched_when_clause
{

	@Element
	private String kw_when = "when";

	@Element
	private search_condition search_condition = new search_condition( );

	@Element
	private String kw_then = "then";

	@Element
	private result result = new result( );

	public search_condition getSearch_condition( )
	{
		return search_condition;
	}

	public result getResult( )
	{
		return result;
	}

}
