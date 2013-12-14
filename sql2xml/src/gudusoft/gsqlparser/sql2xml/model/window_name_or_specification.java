
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class window_name_or_specification
{

	@Element(required = false)
	private window_name window_name;

	@Element(required = false)
	private in_line_window_specification in_line_window_specification;

	public window_name getWindow_name( )
	{
		return window_name;
	}

	public void setWindow_name( window_name window_name )
	{
		this.window_name = window_name;
	}

	public in_line_window_specification getIn_line_window_specification( )
	{
		return in_line_window_specification;
	}

	public void setIn_line_window_specification(
			in_line_window_specification in_line_window_specification )
	{
		this.in_line_window_specification = in_line_window_specification;
	}

}
