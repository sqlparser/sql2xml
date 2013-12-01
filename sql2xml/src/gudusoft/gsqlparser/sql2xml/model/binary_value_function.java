
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class binary_value_function
{

	@Element(required = false)
	private binary_substring_function binary_substring_function;

	@Element(required = false)
	private binary_trim_function binary_trim_function;

	@Element(required = false)
	private binary_overlay_function binary_overlay_function;

	public binary_substring_function getBinary_substring_function( )
	{
		return binary_substring_function;
	}

	public void setBinary_substring_function(
			binary_substring_function binary_substring_function )
	{
		this.binary_substring_function = binary_substring_function;
	}

	public binary_trim_function getBinary_trim_function( )
	{
		return binary_trim_function;
	}

	public void setBinary_trim_function(
			binary_trim_function binary_trim_function )
	{
		this.binary_trim_function = binary_trim_function;
	}

	public binary_overlay_function getBinary_overlay_function( )
	{
		return binary_overlay_function;
	}

	public void setBinary_overlay_function(
			binary_overlay_function binary_overlay_function )
	{
		this.binary_overlay_function = binary_overlay_function;
	}

}
