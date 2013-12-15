
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class interval_fractional_seconds_precision
{

	@Element
	private String unsigned_integer;

	public String getUnsigned_integer( )
	{
		return unsigned_integer;
	}

	public void setUnsigned_integer( String unsigned_integer )
	{
		this.unsigned_integer = unsigned_integer;
	}

}
