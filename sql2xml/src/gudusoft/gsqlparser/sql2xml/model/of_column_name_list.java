
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class of_column_name_list
{

	@Element
	private String kw_of = "of";

	@Element
	private column_name_list column_name_list;

	public column_name_list getColumn_name_list( )
	{
		return column_name_list;
	}

	public void setColumn_name_list( column_name_list column_name_list )
	{
		this.column_name_list = column_name_list;
	}

}
