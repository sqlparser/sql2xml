
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class asterisked_identifier_chain_asterisk
{

	@Element
	private asterisked_identifier_chain asterisked_identifier_chain = new asterisked_identifier_chain( );

	@Element
	private String asterisk = "*";

	public asterisked_identifier_chain getAsterisked_identifier_chain( )
	{
		return asterisked_identifier_chain;
	}

}
