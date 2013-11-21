
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class table_or_query_name_as_correlation_name
{

	@Element
	private table_or_query_name table_or_query_name = new table_or_query_name( );

	@Element(required = false)
	private correlation_name_with_derived_column_list correlation_name_with_derived_column_list;

	public correlation_name_with_derived_column_list getCorrelation_name_with_derived_column_list( )
	{
		return correlation_name_with_derived_column_list;
	}

	public void setCorrelation_name_with_derived_column_list(
			correlation_name_with_derived_column_list correlation_name_with_derived_column_list )
	{
		this.correlation_name_with_derived_column_list = correlation_name_with_derived_column_list;
	}

	public table_or_query_name getTable_or_query_name( )
	{
		return table_or_query_name;
	}

}
