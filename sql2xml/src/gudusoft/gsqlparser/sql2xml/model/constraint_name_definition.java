
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class constraint_name_definition
{

	@Element
	private String kw_constraint = "constraint";

	@Element
	private constraint_name constraint_name = new constraint_name( );

	public constraint_name getConstraint_name( )
	{
		return constraint_name;
	}

}
