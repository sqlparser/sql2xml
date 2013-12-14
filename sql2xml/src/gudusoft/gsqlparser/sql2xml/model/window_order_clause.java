
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class window_order_clause
{

	@Element
	private String kw_order = "order";

	@Element
	private String kw_by = "by";

	@Element
	private sort_specification_list sort_specification_list = new sort_specification_list( );

	public sort_specification_list getSort_specification_list( )
	{
		return sort_specification_list;
	}

}
