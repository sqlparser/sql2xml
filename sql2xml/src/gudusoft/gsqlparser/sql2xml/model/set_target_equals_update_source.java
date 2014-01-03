
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class set_target_equals_update_source
{

	@Element
	private set_target set_target = new set_target( );

	@Element
	private String equals_operator = "=";

	@Element
	private update_source update_source = new update_source( );

	public set_target getSet_target( )
	{
		return set_target;
	}

	public update_source getUpdate_source( )
	{
		return update_source;
	}

}
