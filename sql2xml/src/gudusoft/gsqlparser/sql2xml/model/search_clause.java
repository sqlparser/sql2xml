
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class search_clause
{

	@Element
	private String kw_search;

	@Element
	private recursive_search_order recursive_search_order;

	@Element
	private String kw_set;

	@Element
	private sequence_column sequence_column;
}
