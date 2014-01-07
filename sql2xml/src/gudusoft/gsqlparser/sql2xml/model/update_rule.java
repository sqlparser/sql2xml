
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class update_rule
{

	@Element
	private String kw_on = "on";

	@Element
	private String kw_update = "update";

	@Element
	private referential_action referential_action = new referential_action( );

	public referential_action getReferential_action( )
	{
		return referential_action;
	}

}
