
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class float_with_precision
{

	@Element
	private String kw_float = "float";

	@Element(required = false)
	private precision precision;

	public precision getPrecision( )
	{
		return precision;
	}

	public void setPrecision( precision precision )
	{
		this.precision = precision;
	}

}
