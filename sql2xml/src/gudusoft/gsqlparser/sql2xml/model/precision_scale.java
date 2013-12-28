
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class precision_scale
{

	@Element
	private precision precision = new precision( );

	@Element(required = false)
	private scale scale;

	public scale getScale( )
	{
		return scale;
	}

	public void setScale( scale scale )
	{
		this.scale = scale;
	}

	public precision getPrecision( )
	{
		return precision;
	}

}
