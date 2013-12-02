
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

	public row_value_constructor_element_list_with_paren getRow_value_constructor_element_list_with_paren( )
	{
		return row_value_constructor_element_list_with_paren;
	}

	public void setRow_value_constructor_element_list_with_paren(
			row_value_constructor_element_list_with_paren row_value_constructor_element_list_with_paren )
	{
		this.row_value_constructor_element_list_with_paren = row_value_constructor_element_list_with_paren;
	}

	public row_value_constructor_element_list_with_row getRow_value_constructor_element_list_with_row( )
	{
		return row_value_constructor_element_list_with_row;
	}

	public void setRow_value_constructor_element_list_with_row(
			row_value_constructor_element_list_with_row row_value_constructor_element_list_with_row )
	{
		this.row_value_constructor_element_list_with_row = row_value_constructor_element_list_with_row;
	}

	public row_subquery getRow_subquery( )
	{
		return row_subquery;
	}

	public void setRow_subquery( row_subquery row_subquery )
	{
		this.row_subquery = row_subquery;
	}

}
