
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class column_constraint_definition
{

	@Element(required = false)
	private constraint_name_definition constraint_name_definition;

	@Element
	private column_constraint column_constraint = new column_constraint( );

	@Element(required = false)
	private constraint_characteristics constraint_characteristics;

	public void setConstraint_characteristics(
			constraint_characteristics constraint_characteristics )
	{
		this.constraint_characteristics = constraint_characteristics;
	}

	public constraint_name_definition getConstraint_name_definition( )
	{
		return constraint_name_definition;
	}

	public void setConstraint_name_definition(
			constraint_name_definition constraint_name_definition )
	{
		this.constraint_name_definition = constraint_name_definition;
	}

	public column_constraint getColumn_constraint( )
	{
		return column_constraint;
	}

	public constraint_characteristics getConstraint_characteristics( )
	{
		return constraint_characteristics;
	}

}
