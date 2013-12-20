
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class domain_name
{

	@Element
	private schema_qualified_name schema_qualified_name = new schema_qualified_name( );

	public schema_qualified_name getSchema_qualified_name( )
	{
		return schema_qualified_name;
	}

}
