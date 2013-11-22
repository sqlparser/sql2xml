
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class only_spec
{

	@Element
	private String kw_only = "only";

	@Element
	private table_or_query_name table_or_query_name = new table_or_query_name( );

	public table_or_query_name getTable_or_query_name( )
	{
		return table_or_query_name;
	}

}
