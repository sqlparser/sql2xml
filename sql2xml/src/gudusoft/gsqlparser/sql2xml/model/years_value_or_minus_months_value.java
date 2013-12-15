
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class years_value_or_minus_months_value
{

	@Element
	private years_value years_value = new years_value( );

	@Element(required = false)
	private minus_months_value minus_months_value;

	public minus_months_value getMinus_months_value( )
	{
		return minus_months_value;
	}

	public void setMinus_months_value( minus_months_value minus_months_value )
	{
		this.minus_months_value = minus_months_value;
	}

	public years_value getYears_value( )
	{
		return years_value;
	}

}
