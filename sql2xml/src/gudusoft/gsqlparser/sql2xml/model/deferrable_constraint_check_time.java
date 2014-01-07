
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class deferrable_constraint_check_time
{

	@Element
	private kw_not_deferrable kw_not_deferrable = new kw_not_deferrable( );

	@Element(required = false)
	private constraint_check_time constraint_check_time;

	public constraint_check_time getConstraint_check_time( )
	{
		return constraint_check_time;
	}

	public void setConstraint_check_time(
			constraint_check_time constraint_check_time )
	{
		this.constraint_check_time = constraint_check_time;
	}

	public kw_not_deferrable getKw_not_deferrable( )
	{
		return kw_not_deferrable;
	}

}
