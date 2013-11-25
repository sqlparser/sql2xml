
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class width_bucket_function
{

	@Element
	private String kw_width_bucket = "width_bucket";

	@Element
	private width_bucket_operand width_bucket_operand = new width_bucket_operand( );

	@Element
	private width_bucket_bound_1 width_bucket_bound_1 = new width_bucket_bound_1( );

	@Element
	private width_bucket_bound_2 width_bucket_bound_2 = new width_bucket_bound_2( );

	@Element
	private width_bucket_count width_bucket_count = new width_bucket_count( );

	public width_bucket_operand getWidth_bucket_operand( )
	{
		return width_bucket_operand;
	}

	public width_bucket_bound_1 getWidth_bucket_bound_1( )
	{
		return width_bucket_bound_1;
	}

	public width_bucket_bound_2 getWidth_bucket_bound_2( )
	{
		return width_bucket_bound_2;
	}

	public width_bucket_count getWidth_bucket_count( )
	{
		return width_bucket_count;
	}

}
