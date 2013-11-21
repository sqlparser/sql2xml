
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class derived_table_as_correlation_name
{

	@Element
	private derived_table derived_table = new derived_table( );

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

	public derived_table getDerived_table( )
	{
		return derived_table;
	}

}
