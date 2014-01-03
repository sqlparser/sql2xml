
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class object_column
{

	@Element
	private column_name column_name = new column_name( );

	public column_name getColumn_name( )
	{
		return column_name;
	}

}
