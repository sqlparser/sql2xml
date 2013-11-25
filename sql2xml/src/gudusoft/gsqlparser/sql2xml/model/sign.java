
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class sign
{

	@Element(required = false)
	private String plus_sign;

	@Element(required = false)
	private String minus_sign;

	public String getPlus_sign( )
	{
		return plus_sign;
	}

	public void setPlus_sign( String plus_sign )
	{
		this.plus_sign = plus_sign;
	}

	public String getMinus_sign( )
	{
		return minus_sign;
	}

	public void setMinus_sign( String minus_sign )
	{
		this.minus_sign = minus_sign;
	}

}
