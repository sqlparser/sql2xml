package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class table_or_query_name_as_correlation_name
{
	@Element
	private table_or_query_name table_or_query_name;
	
	@Element(required = false)
	private correlation_name_with_derived_column_list correlation_name_with_derived_column_list;
}