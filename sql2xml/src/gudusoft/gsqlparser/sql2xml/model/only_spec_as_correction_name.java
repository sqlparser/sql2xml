package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class only_spec_as_correction_name
{
	@Element
	private only_spec only_spec;
	
	@Element(required = false)
	private correlation_name_with_derived_column_list correlation_name_with_derived_column_list;
}
