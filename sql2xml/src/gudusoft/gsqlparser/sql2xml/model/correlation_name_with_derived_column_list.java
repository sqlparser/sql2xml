package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class correlation_name_with_derived_column_list
{
	@Element(required = false)
	private String kw_as;

	@Element
	private correlation_name correlation_name;
	
	@Element(required = false)
	private derived_column_list derived_column_list;
}
