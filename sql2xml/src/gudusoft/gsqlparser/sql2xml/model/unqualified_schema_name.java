
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class unqualified_schema_name
{

	@Element
	private identifier identifier = new identifier( );

	public identifier getIdentifier( )
	{
		return identifier;
	}

}
