
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class column_name
{

	@Element
	private identifier identifier;

	public identifier getIdentifier( )
	{
		return identifier;
	}

	public void setIdentifier( identifier identifier )
	{
		this.identifier = identifier;
	}

}
