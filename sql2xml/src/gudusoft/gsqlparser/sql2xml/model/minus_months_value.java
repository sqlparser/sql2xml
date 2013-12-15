
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class minus_months_value
{

	@Element
	private String minus_sign = "-";

	@Element
	private months_value months_value = new months_value( );

	public months_value getMonths_value( )
	{
		return months_value;
	}

}
