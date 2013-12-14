
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class window_frame_clause
{

	@Element
	private window_frame_units window_frame_units = new window_frame_units( );

	@Element
	private window_frame_extent window_frame_extent = new window_frame_extent( );

	@Element(required = false)
	private window_frame_exclusion window_frame_exclusion;

	public window_frame_exclusion getWindow_frame_exclusion( )
	{
		return window_frame_exclusion;
	}

	public void setWindow_frame_exclusion(
			window_frame_exclusion window_frame_exclusion )
	{
		this.window_frame_exclusion = window_frame_exclusion;
	}

	public window_frame_units getWindow_frame_units( )
	{
		return window_frame_units;
	}

	public window_frame_extent getWindow_frame_extent( )
	{
		return window_frame_extent;
	}

}
