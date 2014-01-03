
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class multiple_column_assignment
{

	@Element
	private set_target_list set_target_list = new set_target_list( );

	@Element
	private String equals_operator = "=";

	@Element
	private assigned_row assigned_row = new assigned_row( );

	public set_target_list getSet_target_list( )
	{
		return set_target_list;
	}

	public assigned_row getAssigned_row( )
	{
		return assigned_row;
	}

}
