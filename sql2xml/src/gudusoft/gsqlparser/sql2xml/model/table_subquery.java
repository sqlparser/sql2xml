
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class table_subquery
{

	@Element
	private subquery subquery = new subquery( );

	public subquery getSubquery( )
	{
		return subquery;
	}

}
