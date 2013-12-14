
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class existing_window_name
{

	@Element
	private window_name window_name = new window_name( );

	public window_name getWindow_name( )
	{
		return window_name;
	}

}
