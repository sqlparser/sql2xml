package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class explicit_row_value_constructor
{
	@Element(required = false)
	private row_value_constructor_element_list_with_paren row_value_constructor_element_list_with_paren;
	
	@Element(required = false)
	private row_value_constructor_element_list_with_row row_value_constructor_element_list_with_row;
	
	@Element(required = false)
	private row_subquery row_subquery;
}
