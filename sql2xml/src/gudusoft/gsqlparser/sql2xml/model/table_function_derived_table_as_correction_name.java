package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class table_function_derived_table_as_correction_name
{
	@Element
	private table_function_derived_table table_function_derived_table;
	
	@Element(required = false)
	private correlation_name_with_derived_column_list correlation_name_with_derived_column_list;
}
