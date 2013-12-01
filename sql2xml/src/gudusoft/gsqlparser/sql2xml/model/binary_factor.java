
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class binary_factor
{

	@Element
	private binary_primary binary_primary = new binary_primary( );

	public binary_primary getBinary_primary( )
	{
		return binary_primary;
	}

}
