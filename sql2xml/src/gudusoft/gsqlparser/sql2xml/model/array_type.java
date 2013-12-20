
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class array_type
{

	@Element
	private data_type data_type = new data_type( );

	@Element
	private String kw_array = "array";

	@Element(required = false)
	private maximum_cardninality maximum_cardninality;

	public maximum_cardninality getMaximum_cardninality( )
	{
		return maximum_cardninality;
	}

	public void setMaximum_cardninality(
			maximum_cardninality maximum_cardninality )
	{
		this.maximum_cardninality = maximum_cardninality;
	}

	public data_type getData_type( )
	{
		return data_type;
	}

}
