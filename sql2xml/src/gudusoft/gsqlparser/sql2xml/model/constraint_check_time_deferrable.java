
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class constraint_check_time_deferrable
{

	@Element
	private constraint_check_time constraint_check_time = new constraint_check_time( );

	@Element(required = false)
	private kw_not_deferrable kw_not_deferrable;

	public kw_not_deferrable getKw_not_deferrable( )
	{
		return kw_not_deferrable;
	}

	public void setKw_not_deferrable( kw_not_deferrable kw_not_deferrable )
	{
		this.kw_not_deferrable = kw_not_deferrable;
	}

	public constraint_check_time getConstraint_check_time( )
	{
		return constraint_check_time;
	}

}
