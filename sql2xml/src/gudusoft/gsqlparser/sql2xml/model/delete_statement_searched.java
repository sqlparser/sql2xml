
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class delete_statement_searched
{

	@Element
	private String kw_delete = "delete";

	@Element
	private String kw_from = "from";

	@Element
	private target_table target_table = new target_table( );

	@Element(required = false)
	private as_correlation_name as_correlation_name;

	@Element(required = false)
	private where_search_condition where_search_condition;

	public as_correlation_name getAs_correlation_name( )
	{
		return as_correlation_name;
	}

	public void setAs_correlation_name( as_correlation_name as_correlation_name )
	{
		this.as_correlation_name = as_correlation_name;
	}

	public where_search_condition getWhere_search_condition( )
	{
		return where_search_condition;
	}

	public void setWhere_search_condition(
			where_search_condition where_search_condition )
	{
		this.where_search_condition = where_search_condition;
	}

	public target_table getTarget_table( )
	{
		return target_table;
	}

}
