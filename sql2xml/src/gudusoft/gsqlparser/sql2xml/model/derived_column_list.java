
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class derived_column_list
{

	@Element
	private column_name_list column_name_list = new column_name_list( );

	public column_name_list getColumn_name_list( )
	{
		return column_name_list;
	}

}
