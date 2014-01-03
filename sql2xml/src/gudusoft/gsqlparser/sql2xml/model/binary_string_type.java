
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class binary_string_type
{

	@Element(required = false)
	private binary_with_length binary_with_length;

	@Element(required = false)
	private binary_varying_with_length binary_varying_with_length;

	@Element(required = false)
	private varbinary_with_length varbinary_with_length;

	@Element(required = false)
	private binary_large_object_string_type binary_large_object_string_type;

	public binary_with_length getBinary_with_length( )
	{
		return binary_with_length;
	}

	public void setBinary_with_length( binary_with_length binary_with_length )
	{
		this.binary_with_length = binary_with_length;
	}

	public binary_varying_with_length getBinary_varying_with_length( )
	{
		return binary_varying_with_length;
	}

	public void setBinary_varying_with_length(
			binary_varying_with_length binary_varying_with_length )
	{
		this.binary_varying_with_length = binary_varying_with_length;
	}

	public varbinary_with_length getVarbinary_with_length( )
	{
		return varbinary_with_length;
	}

	public void setVarbinary_with_length(
			varbinary_with_length varbinary_with_length )
	{
		this.varbinary_with_length = varbinary_with_length;
	}

	public binary_large_object_string_type getBinary_large_object_string_type( )
	{
		return binary_large_object_string_type;
	}

	public void setBinary_large_object_string_type(
			binary_large_object_string_type binary_large_object_string_type )
	{
		this.binary_large_object_string_type = binary_large_object_string_type;
	}

}
