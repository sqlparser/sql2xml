
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class reference_type
{

	@Element
	private String kw_ref = "ref";

	@Element
	private referenced_type referenced_type = new referenced_type( );

	@Element(required = false)
	private scope_clause scope_clause;

	public scope_clause getScope_clause( )
	{
		return scope_clause;
	}

	public void setScope_clause( scope_clause scope_clause )
	{
		this.scope_clause = scope_clause;
	}

	public referenced_type getReferenced_type( )
	{
		return referenced_type;
	}

}
