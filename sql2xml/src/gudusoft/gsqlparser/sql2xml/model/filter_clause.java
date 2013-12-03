
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class filter_clause
{

	@Element
	private String kw_filter = "filter";

	@Element
	private String kw_where = "where";

	@Element
	private search_condition search_condition = new search_condition( );

	public search_condition getSearch_condition( )
	{
		return search_condition;
	}

}
