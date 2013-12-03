
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class set_function_specification
{

	@Element(required = false)
	private aggregate_function aggregate_function;

	@Element(required = false)
	private grouping_operation grouping_operation;

	public aggregate_function getAggregate_function( )
	{
		return aggregate_function;
	}

	public void setAggregate_function( aggregate_function aggregate_function )
	{
		this.aggregate_function = aggregate_function;
	}

	public grouping_operation getGrouping_operation( )
	{
		return grouping_operation;
	}

	public void setGrouping_operation( grouping_operation grouping_operation )
	{
		this.grouping_operation = grouping_operation;
	}

}
