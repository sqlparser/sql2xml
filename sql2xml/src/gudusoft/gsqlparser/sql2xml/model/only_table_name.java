
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class only_table_name
{

	@Element
	private String kw_only = "only";

	@Element
	private table_name table_name = new table_name( );

	public table_name getTable_name( )
	{
		return table_name;
	}

}
