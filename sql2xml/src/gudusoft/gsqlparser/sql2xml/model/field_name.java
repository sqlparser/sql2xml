
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class field_name
{

	@Element
	private identifier identifier = new identifier( );

	public identifier getIdentifier( )
	{
		return identifier;
	}

}
