
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class binary_trim_function
{

	@Element
	private String kw_trim = "trim";

	@Element
	private binary_trim_operands binary_trim_operands = new binary_trim_operands( );

	public binary_trim_operands getBinary_trim_operands( )
	{
		return binary_trim_operands;
	}

}
