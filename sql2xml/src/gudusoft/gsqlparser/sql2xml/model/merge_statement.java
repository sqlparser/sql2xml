
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class merge_statement
{

	@Element
	private String kw_merge = "merge";

	@Element
	private String kw_into = "into";

	@Element
	private target_table target_table = new target_table( );

	@Element(required = false)
	private as_merge_correlation_name as_merge_correlation_name;

	@Element
	private String kw_using = "using";

	@Element
	private table_reference table_reference = new table_reference( );

	@Element
	private String kw_on = "on";

	@Element
	private search_condition search_condition = new search_condition( );

	@Element
	private merge_operation_specification merge_operation_specification = new merge_operation_specification( );

	public as_merge_correlation_name getAs_merge_correlation_name( )
	{
		return as_merge_correlation_name;
	}

	public void setAs_merge_correlation_name(
			as_merge_correlation_name as_merge_correlation_name )
	{
		this.as_merge_correlation_name = as_merge_correlation_name;
	}

	public target_table getTarget_table( )
	{
		return target_table;
	}

	public table_reference getTable_reference( )
	{
		return table_reference;
	}

	public search_condition getSearch_condition( )
	{
		return search_condition;
	}

	public merge_operation_specification getMerge_operation_specification( )
	{
		return merge_operation_specification;
	}

}
