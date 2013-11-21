
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class all_fields_reference
{

	@Element
	private value_expression_primary value_expression_primary = new value_expression_primary( );

	@Element
	private String asterisk = "*";

	@Element(required = false)
	private as_all_fields_column_name_list as_all_fields_column_name_list;

	public as_all_fields_column_name_list getAs_all_fields_column_name_list( )
	{
		return as_all_fields_column_name_list;
	}

	public void setAs_all_fields_column_name_list(
			as_all_fields_column_name_list as_all_fields_column_name_list )
	{
		this.as_all_fields_column_name_list = as_all_fields_column_name_list;
	}

	public value_expression_primary getValue_expression_primary( )
	{
		return value_expression_primary;
	}

}
