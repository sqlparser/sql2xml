
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class datetime_literal
{

	@Element(required = false)
	private date_literal date_literal;

	@Element(required = false)
	private time_literal time_literal;

	@Element(required = false)
	private timestamp_literal timestamp_literal;

	public date_literal getDate_literal( )
	{
		return date_literal;
	}

	public void setDate_literal( date_literal date_literal )
	{
		this.date_literal = date_literal;
	}

	public time_literal getTime_literal( )
	{
		return time_literal;
	}

	public void setTime_literal( time_literal time_literal )
	{
		this.time_literal = time_literal;
	}

	public timestamp_literal getTimestamp_literal( )
	{
		return timestamp_literal;
	}

	public void setTimestamp_literal( timestamp_literal timestamp_literal )
	{
		this.timestamp_literal = timestamp_literal;
	}

}
