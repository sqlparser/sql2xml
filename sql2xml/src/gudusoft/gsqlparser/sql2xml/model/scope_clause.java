
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class scope_clause
{

	@Element
	private String kw_scope = "scope";

	@Element
	private table_name table_name = new table_name( );

	public table_name getTable_name( )
	{
		return table_name;
	}

}
