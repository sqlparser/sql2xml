
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class start_to_end_field
{

	@Element
	private start_field start_field = new start_field( );

	@Element
	private String kw_to = "to";

	@Element
	private end_field end_field = new end_field( );

	public start_field getStart_field( )
	{
		return start_field;
	}

	public end_field getEnd_field( )
	{
		return end_field;
	}

}
