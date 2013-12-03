
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class aggregate_function
{

	@Element(required = false)
	private aggregate_count aggregate_count;

	@Element(required = false)
	private aggregate_function_general_set aggregate_function_general_set;

	@Element(required = false)
	private aggregate_function_binary_set aggregate_function_binary_set;

	@Element(required = false)
	private aggregate_function_ordered_set aggregate_function_ordered_set;

	public aggregate_count getAggregate_count( )
	{
		return aggregate_count;
	}

	public void setAggregate_count( aggregate_count aggregate_count )
	{
		this.aggregate_count = aggregate_count;
	}

	public aggregate_function_general_set getAggregate_function_general_set( )
	{
		return aggregate_function_general_set;
	}

	public void setAggregate_function_general_set(
			aggregate_function_general_set aggregate_function_general_set )
	{
		this.aggregate_function_general_set = aggregate_function_general_set;
	}

	public aggregate_function_binary_set getAggregate_function_binary_set( )
	{
		return aggregate_function_binary_set;
	}

	public void setAggregate_function_binary_set(
			aggregate_function_binary_set aggregate_function_binary_set )
	{
		this.aggregate_function_binary_set = aggregate_function_binary_set;
	}

	public aggregate_function_ordered_set getAggregate_function_ordered_set( )
	{
		return aggregate_function_ordered_set;
	}

	public void setAggregate_function_ordered_set(
			aggregate_function_ordered_set aggregate_function_ordered_set )
	{
		this.aggregate_function_ordered_set = aggregate_function_ordered_set;
	}

}
