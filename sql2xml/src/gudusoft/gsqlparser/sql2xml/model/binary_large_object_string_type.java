
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class binary_large_object_string_type
{

	@Element(required = false)
	private binary_large_object_with_length binary_large_object_with_length;

	@Element(required = false)
	private blob_with_length blob_with_length;

	public binary_large_object_with_length getBinary_large_object_with_length( )
	{
		return binary_large_object_with_length;
	}

	public void setBinary_large_object_with_length(
			binary_large_object_with_length binary_large_object_with_length )
	{
		this.binary_large_object_with_length = binary_large_object_with_length;
	}

	public blob_with_length getBlob_with_length( )
	{
		return blob_with_length;
	}

	public void setBlob_with_length( blob_with_length blob_with_length )
	{
		this.blob_with_length = blob_with_length;
	}

}
