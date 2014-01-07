
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class column_constraint
{

	@Element(required = false)
	private not_null not_null;

	@Element(required = false)
	private unique_specification unique_specification;

	@Element(required = false)
	private references_specification references_specification;

	@Element(required = false)
	private check_constraint_definition check_constraint_definition;

	public not_null getNot_null( )
	{
		return not_null;
	}

	public void setNot_null( not_null not_null )
	{
		this.not_null = not_null;
	}

	public unique_specification getUnique_specification( )
	{
		return unique_specification;
	}

	public void setUnique_specification(
			unique_specification unique_specification )
	{
		this.unique_specification = unique_specification;
	}

	public references_specification getReferences_specification( )
	{
		return references_specification;
	}

	public void setReferences_specification(
			references_specification references_specification )
	{
		this.references_specification = references_specification;
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
