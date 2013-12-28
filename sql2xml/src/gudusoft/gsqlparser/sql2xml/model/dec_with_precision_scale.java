
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class dec_with_precision_scale
{

	@Element
	private String kw_dec = "dec";

	@Element(required = false)
	private precision_scale precision_scale;

	public precision_scale getPrecision_scale( )
	{
		return precision_scale;
	}

	public void setPrecision_scale( precision_scale precision_scale )
	{
		this.precision_scale = precision_scale;
	}
}
