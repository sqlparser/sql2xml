
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class partitioned_join_column_reference
{

	@Element
	private column_reference column_reference = new column_reference( );

	public column_reference getColumn_reference( )
	{
		return column_reference;
	}

}
