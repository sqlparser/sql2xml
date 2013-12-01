
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class normalize_function_result_length
{

	@Element(required = false)
	private length length;

	@Element(required = false)
	private large_object_length large_object_length;

	public length getLength( )
	{
		return length;
	}

	public void setLength( length length )
	{
		this.length = length;
	}

	public large_object_length getLarge_object_length( )
	{
		return large_object_length;
	}

	public void setLarge_object_length( large_object_length large_object_length )
	{
		this.large_object_length = large_object_length;
	}

}
