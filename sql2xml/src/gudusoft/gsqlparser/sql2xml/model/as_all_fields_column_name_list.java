
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class as_all_fields_column_name_list
{

	@Element
	private String kw_as = "as";

	@Element
	private all_fields_column_name_list all_fields_column_name_list = new all_fields_column_name_list( );

	public all_fields_column_name_list getAll_fields_column_name_list( )
	{
		return all_fields_column_name_list;
	}

}
