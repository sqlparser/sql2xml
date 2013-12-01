
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class large_object_length
{

	@Element(required = false)
	private unsigned_integer_multiplier_with_length_units unsigned_integer_multiplier_with_length_units;

	@Element(required = false)
	private large_object_length_token_with_length_units large_object_length_token_with_length_units;

	public unsigned_integer_multiplier_with_length_units getUnsigned_integer_multiplier_with_length_units( )
	{
		return unsigned_integer_multiplier_with_length_units;
	}

	public void setUnsigned_integer_multiplier_with_length_units(
			unsigned_integer_multiplier_with_length_units unsigned_integer_multiplier_with_length_units )
	{
		this.unsigned_integer_multiplier_with_length_units = unsigned_integer_multiplier_with_length_units;
	}

	public large_object_length_token_with_length_units getLarge_object_length_token_with_length_units( )
	{
		return large_object_length_token_with_length_units;
	}

	public void setLarge_object_length_token_with_length_units(
			large_object_length_token_with_length_units large_object_length_token_with_length_units )
	{
		this.large_object_length_token_with_length_units = large_object_length_token_with_length_units;
	}

}
