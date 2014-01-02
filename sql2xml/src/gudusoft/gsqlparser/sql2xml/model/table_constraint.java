
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class table_constraint
{

	@Element(required = false)
	private unique_constraint_definition unique_constraint_definition;

	@Element(required = false)
	private referential_constraint_definition referential_constraint_definition;

	@Element(required = false)
	private check_constraint_definition check_constraint_definition;

	public unique_constraint_definition getUnique_constraint_definition( )
	{
		return unique_constraint_definition;
	}

	public void setUnique_constraint_definition(
			unique_constraint_definition unique_constraint_definition )
	{
		this.unique_constraint_definition = unique_constraint_definition;
	}

	public referential_constraint_definition getReferential_constraint_definition( )
	{
		return referential_constraint_definition;
	}

	public void setReferential_constraint_definition(
			referential_constraint_definition referential_constraint_definition )
	{
		this.referential_constraint_definition = referential_constraint_definition;
	}

	public check_constraint_definition getCheck_constraint_definition( )
	{
		return check_constraint_definition;
	}

	public void setCheck_constraint_definition(
			check_constraint_definition check_constraint_definition )
	{
		this.check_constraint_definition = check_constraint_definition;
	}

}
