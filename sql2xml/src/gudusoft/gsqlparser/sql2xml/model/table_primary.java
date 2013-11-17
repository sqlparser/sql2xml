
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class table_primary
{
	@Element(required = false)
	private table_or_query_name_as_correlation_name table_or_query_name_as_correlation_name;
	
	@Element(required = false)
	private derived_table_as_correlation_name derived_table_as_correlation_name;
	
	@Element(required = false)
	private lateral_derived_table_as_correlation_name lateral_derived_table_as_correlation_name;
	
	@Element(required = false)
	private collection_derived_table_as_correction_name collection_derived_table_as_correction_name;
	
	@Element(required = false)
	private table_function_derived_table_as_correction_name table_function_derived_table_as_correction_name;
	
	@Element(required = false)
	private only_spec_as_correction_name only_spec_as_correction_name;
	
	@Element(required = false)
	private parenthesized_joined_table parenthesized_joined_table;
}
