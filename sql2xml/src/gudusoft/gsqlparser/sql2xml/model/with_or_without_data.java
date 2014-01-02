
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class with_or_without_data
{

	@Element(required = false)
	private without_data without_data;

	@Element(required = false)
	private with_data with_data;

	public without_data getWithout_data( )
	{
		return without_data;
	}

	public void setWithout_data( without_data without_data )
	{
		this.without_data = without_data;
	}

	public with_data getWith_data( )
	{
		return with_data;
	}

	public void setWith_data( with_data with_data )
	{
		this.with_data = with_data;
	}

}
