
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class table_name
{

	@Element
	private local_or_schema_qualified_name local_or_schema_qualified_name = new local_or_schema_qualified_name( );

	public local_or_schema_qualified_name getLocal_or_schema_qualified_name( )
	{
		return local_or_schema_qualified_name;
	}

}
