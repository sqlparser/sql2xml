
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class table_constraint_definition
{

	@Element(required = false)
	private constraint_name_definition constraint_name_definition;

	@Element
	private table_constraint table_constraint = new table_constraint( );

	@Element(required = false)
	private constraint_characteristics constraint_characteristics;

	public constraint_name_definition getConstraint_name_definition( )
	{
		return constraint_name_definition;
	}

	public void setConstraint_name_definition(
			constraint_name_definition constraint_name_definition )
	{
		this.constraint_name_definition = constraint_name_definition;
	}

	public table_constraint getTable_constraint( )
	{
		return table_constraint;
	}

	public constraint_characteristics getConstraint_characteristics( )
	{
		return constraint_characteristics;
	}

}
