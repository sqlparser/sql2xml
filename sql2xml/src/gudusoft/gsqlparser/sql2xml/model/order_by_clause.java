
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class order_by_clause
{

	@Element
	private String kw_order = "order";

	@Element
	private String kw_by = "by";

	@Element
	private sort_specification_list sort_specification_list;

	public sort_specification_list getSort_specification_list( )
	{
		return sort_specification_list;
	}

	public void setSort_specification_list(
			sort_specification_list sort_specification_list )
	{
		this.sort_specification_list = sort_specification_list;
	}

}
