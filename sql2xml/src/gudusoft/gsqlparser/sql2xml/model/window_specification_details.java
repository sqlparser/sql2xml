
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class window_specification_details
{

	@Element(required = false)
	private existing_window_name existing_window_name;

	@Element(required = false)
	private window_partition_clause window_partition_clause;

	@Element(required = false)
	private window_order_clause window_order_clause;

	@Element(required = false)
	private window_frame_clause window_frame_clause;

	public existing_window_name getExisting_window_name( )
	{
		return existing_window_name;
	}

	public void setExisting_window_name(
			existing_window_name existing_window_name )
	{
		this.existing_window_name = existing_window_name;
	}

	public window_partition_clause getWindow_partition_clause( )
	{
		return window_partition_clause;
	}

	public void setWindow_partition_clause(
			window_partition_clause window_partition_clause )
	{
		this.window_partition_clause = window_partition_clause;
	}

	public window_order_clause getWindow_order_clause( )
	{
		return window_order_clause;
	}

	public void setWindow_order_clause( window_order_clause window_order_clause )
	{
		this.window_order_clause = window_order_clause;
	}

	public window_frame_clause getWindow_frame_clause( )
	{
		return window_frame_clause;
	}

	public void setWindow_frame_clause( window_frame_clause window_frame_clause )
	{
		this.window_frame_clause = window_frame_clause;
	}

}
