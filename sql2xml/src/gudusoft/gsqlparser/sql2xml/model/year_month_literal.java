
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class year_month_literal
{

	@Element(required = false)
	private years_value_or_minus_months_value years_value_or_minus_months_value;

	@Element(required = false)
	private months_value months_value;

	public years_value_or_minus_months_value getYears_value_or_minus_months_value( )
	{
		return years_value_or_minus_months_value;
	}

	public void setYears_value_or_minus_months_value(
			years_value_or_minus_months_value years_value_or_minus_months_value )
	{
		this.years_value_or_minus_months_value = years_value_or_minus_months_value;
	}

	public months_value getMonths_value( )
	{
		return months_value;
	}

	public void setMonths_value( months_value months_value )
	{
		this.months_value = months_value;
	}

}
