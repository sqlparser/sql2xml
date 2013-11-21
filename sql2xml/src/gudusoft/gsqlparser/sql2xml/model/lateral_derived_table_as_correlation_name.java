
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class lateral_derived_table_as_correlation_name
{

	@Element
	private lateral_derived_table lateral_derived_table = new lateral_derived_table( );

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

	public lateral_derived_table getLateral_derived_table( )
	{
		return lateral_derived_table;
	}

}
