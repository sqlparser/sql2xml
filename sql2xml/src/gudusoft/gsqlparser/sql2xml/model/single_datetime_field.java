
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class single_datetime_field
{

	@Element(required = false)
	private single_datetime_field_1 single_datetime_field_1;

	@Element(required = false)
	private single_datetime_field_2 single_datetime_field_2;

	public single_datetime_field_1 getSingle_datetime_field_1( )
	{
		return single_datetime_field_1;
	}

	public void setSingle_datetime_field_1(
			single_datetime_field_1 single_datetime_field_1 )
	{
		this.single_datetime_field_1 = single_datetime_field_1;
	}

	public single_datetime_field_2 getSingle_datetime_field_2( )
	{
		return single_datetime_field_2;
	}

	public void setSingle_datetime_field_2(
			single_datetime_field_2 single_datetime_field_2 )
	{
		this.single_datetime_field_2 = single_datetime_field_2;
	}

}
