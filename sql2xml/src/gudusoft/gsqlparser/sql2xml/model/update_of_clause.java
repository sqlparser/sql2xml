
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class update_of_clause
{

	@Element
	private String kw_update = "update";

	@Element(required = false)
	private of_column_name_list of_column_name_list;

	public of_column_name_list getOf_column_name_list( )
	{
		return of_column_name_list;
	}

	public void setOf_column_name_list( of_column_name_list of_column_name_list )
	{
		this.of_column_name_list = of_column_name_list;
	}

}
