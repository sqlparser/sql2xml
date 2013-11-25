
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class factor
{

	@Element(required = false)
	private sign sign;

	@Element
	private numeric_primary numeric_primary = new numeric_primary( );

	public sign getSign( )
	{
		return sign;
	}

	public void setSign( sign sign )
	{
		this.sign = sign;
	}

	public numeric_primary getNumeric_primary( )
	{
		return numeric_primary;
	}

}
