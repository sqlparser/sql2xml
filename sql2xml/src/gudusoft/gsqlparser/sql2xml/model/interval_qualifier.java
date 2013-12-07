
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class interval_qualifier
{

	@Element(required = false)
	private start_to_end_field start_to_end_field;

	@Element(required = false)
	private single_datetime_field single_datetime_field;

	public start_to_end_field getStart_to_end_field( )
	{
		return start_to_end_field;
	}

	public void setStart_to_end_field( start_to_end_field start_to_end_field )
	{
		this.start_to_end_field = start_to_end_field;
	}

	public single_datetime_field getSingle_datetime_field( )
	{
		return single_datetime_field;
	}

	public void setSingle_datetime_field(
			single_datetime_field single_datetime_field )
	{
		this.single_datetime_field = single_datetime_field;
	}

}
