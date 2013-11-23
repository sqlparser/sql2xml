
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class asterisked_identifier
{

	@Element
	private identifier identifier = new identifier( );

	public identifier getIdentifier( )
	{
		return identifier;
	}

}
