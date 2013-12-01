
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class from_start_position
{

	@Element
	private String kw_from = "from";

	@Element
	private start_position start_position = new start_position( );

	public start_position getStart_position( )
	{
		return start_position;
	}

}
