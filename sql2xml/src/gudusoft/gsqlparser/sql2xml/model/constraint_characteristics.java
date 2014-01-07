
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class constraint_characteristics
{

	@Element(required = false)
	private constraint_check_time_deferrable constraint_check_time_deferrable;

	@Element(required = false)
	private deferrable_constraint_check_time deferrable_constraint_check_time;

	public constraint_check_time_deferrable getConstraint_check_time_deferrable( )
	{
		return constraint_check_time_deferrable;
	}

	public void setConstraint_check_time_deferrable(
			constraint_check_time_deferrable constraint_check_time_deferrable )
	{
		this.constraint_check_time_deferrable = constraint_check_time_deferrable;
	}

	public deferrable_constraint_check_time getDeferrable_constraint_check_time( )
	{
		return deferrable_constraint_check_time;
	}

	public void setDeferrable_constraint_check_time(
			deferrable_constraint_check_time deferrable_constraint_check_time )
	{
		this.deferrable_constraint_check_time = deferrable_constraint_check_time;
	}

}
