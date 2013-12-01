
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class collate_clause
{

	@Element
	private String kw_collate = "collate";

	@Element
	private collation_name collation_name = new collation_name( );

	public collation_name getCollation_name( )
	{
		return collation_name;
	}

}
