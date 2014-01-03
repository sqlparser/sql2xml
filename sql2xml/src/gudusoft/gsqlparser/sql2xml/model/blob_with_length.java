
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class blob_with_length
{

	@Element
	private String kw_blob = "blob";

	@Element(required = false)
	private large_object_length large_object_length;

	public large_object_length getLarge_object_length( )
	{
		return large_object_length;
	}

	public void setLarge_object_length( large_object_length large_object_length )
	{
		this.large_object_length = large_object_length;
	}

}
