
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class cross_join
{

	@Element
	private table_reference table_reference = new table_reference( );

	@Element
	private table_factor table_factor = new table_factor( );

	public table_reference getTable_reference( )
	{
		return table_reference;
	}

	public table_factor getTable_factor( )
	{
		return table_factor;
	}

}
