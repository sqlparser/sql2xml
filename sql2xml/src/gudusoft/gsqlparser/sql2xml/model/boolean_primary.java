
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class boolean_primary
{

	@Element(required = false)
	private predicate predicate;

	@Element(required = false)
	private boolean_predicand boolean_predicand;

	public predicate getPredicate( )
	{
		return predicate;
	}

	public void setPredicate( predicate predicate )
	{
		this.predicate = predicate;
	}

	public boolean_predicand getBoolean_predicand( )
	{
		return boolean_predicand;
	}

	public void setBoolean_predicand( boolean_predicand boolean_predicand )
	{
		this.boolean_predicand = boolean_predicand;
	}

}
