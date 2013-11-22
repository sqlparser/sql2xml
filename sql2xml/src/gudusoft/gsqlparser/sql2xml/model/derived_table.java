
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class derived_table
{

	@Element
	private table_subquery table_subquery = new table_subquery( );

	public table_subquery getTable_subquery( )
	{
		return table_subquery;
	}

}
