
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class in_line_window_specification
{

	@Element
	private window_specification window_specification = new window_specification( );

	public window_specification getWindow_specification( )
	{
		return window_specification;
	}

}
