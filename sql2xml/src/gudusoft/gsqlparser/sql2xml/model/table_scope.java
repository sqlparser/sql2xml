
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class table_scope
{

	@Element
	private global_or_local global_or_local = new global_or_local( );

	@Element
	private String kw_temporary = "temporary";

	public global_or_local getGlobal_or_local( )
	{
		return global_or_local;
	}

}
