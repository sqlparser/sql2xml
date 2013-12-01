
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class trim_function
{

	@Element
	private String kw_trim = "trim";

	@Element
	trim_operands trim_operands = new trim_operands( );

	public trim_operands getTrim_operands( )
	{
		return trim_operands;
	}

}
