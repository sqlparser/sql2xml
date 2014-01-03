
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class set_target
{

	@Element(required = false)
	private update_target update_target;

	@Element(required = false)
	private mutated_set_clause mutated_set_clause;

	public update_target getUpdate_target( )
	{
		return update_target;
	}

	public void setUpdate_target( update_target update_target )
	{
		this.update_target = update_target;
	}

	public mutated_set_clause getMutated_set_clause( )
	{
		return mutated_set_clause;
	}

	public void setMutated_set_clause( mutated_set_clause mutated_set_clause )
	{
		this.mutated_set_clause = mutated_set_clause;
	}

}
