
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class table_function_derived_table_as_correction_name
{

	@Element
	private table_function_derived_table table_function_derived_table = new table_function_derived_table( );

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

	public table_function_derived_table getTable_function_derived_table( )
	{
		return table_function_derived_table;
	}

}
