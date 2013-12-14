
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class window_function
{

	@Element
	private window_function_type window_function_type = new window_function_type( );

	@Element
	private String kw_over = "over";

	@Element
	private window_name_or_specification window_name_or_specification = new window_name_or_specification( );

	public window_function_type getWindow_function_type( )
	{
		return window_function_type;
	}

	public window_name_or_specification getWindow_name_or_specification( )
	{
		return window_name_or_specification;
	}

}
