
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class aggregate_count
{

	@Element
	private String kw_count = "count";

	@Element
	private String asterisk = "*";

	@Element(required = false)
	private filter_clause filter_clause;

	public filter_clause getFilter_clause( )
	{
		return filter_clause;
	}

	public void setFilter_clause( filter_clause filter_clause )
	{
		this.filter_clause = filter_clause;
	}

}
