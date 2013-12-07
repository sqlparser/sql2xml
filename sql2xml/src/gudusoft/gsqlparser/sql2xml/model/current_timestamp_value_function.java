
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class current_timestamp_value_function
{

	@Element
	private String kw_current_timestamp = "current_timestamp";

	@Element(required = false)
	private timestamp_precision timestamp_precision;

	public timestamp_precision getTimestamp_precision( )
	{
		return timestamp_precision;
	}

	public void setTimestamp_precision( timestamp_precision timestamp_precision )
	{
		this.timestamp_precision = timestamp_precision;
	}

}
