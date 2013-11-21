
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class basic_identifier_chain
{

	@Element
	private identifier_chain identifier_chain = new identifier_chain( );

	public identifier_chain getIdentifier_chain( )
	{
		return identifier_chain;
	}

}
