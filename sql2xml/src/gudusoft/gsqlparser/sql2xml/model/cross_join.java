
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class cross_join
{

	@Element(required = false)
	private table_reference table_reference;

	@Element(required = false)
	private table_factor table_factor;

	public table_reference getTable_reference( )
	{
		return table_reference;
	}

	public void setTable_reference( table_reference table_reference )
	{
		this.table_reference = table_reference;
	}

	public table_factor getTable_factor( )
	{
		return table_factor;
	}

	public void setTable_factor( table_factor table_factor )
	{
		this.table_factor = table_factor;
	}

}
