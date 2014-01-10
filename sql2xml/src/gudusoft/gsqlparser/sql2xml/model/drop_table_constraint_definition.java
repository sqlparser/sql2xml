
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class drop_table_constraint_definition
{

	@Element
	private String kw_drop = "drop";

	@Element
	private String kw_constraint = "constraint";

	@Element
	private constraint_name constraint_name = new constraint_name( );

	@Element
	private drop_behavior drop_behavior = new drop_behavior( );

	public constraint_name getConstraint_name( )
	{
		return constraint_name;
	}

	public drop_behavior getDrop_behavior( )
	{
		return drop_behavior;
	}

}
