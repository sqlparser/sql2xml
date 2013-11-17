package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class derived_table_as_correlation_name
{
	@Element
	private derived_table derived_table;
	
	@Element(required = false)
	private correlation_name_with_derived_column_list correlation_name_with_derived_column_list;
}
