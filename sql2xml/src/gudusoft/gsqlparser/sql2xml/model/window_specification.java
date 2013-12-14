
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class window_specification
{

	@Element
	private window_specification_details window_specification_details = new window_specification_details( );

	public window_specification_details getWindow_specification_details( )
	{
		return window_specification_details;
	}

}
