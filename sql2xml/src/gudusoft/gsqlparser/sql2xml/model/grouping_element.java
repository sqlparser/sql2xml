
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class grouping_element
{

	@Element(required = false)
	private ordinary_grouping_set ordinary_grouping_set;

	@Element(required = false)
	private rollup_list rollup_list;

	@Element(required = false)
	private cube_list cube_list;

	@Element(required = false)
	private grouping_sets_specification grouping_sets_specification;

	@Element(required = false)
	private empty_grouping_set empty_grouping_set;

	public ordinary_grouping_set getOrdinary_grouping_set( )
	{
		return ordinary_grouping_set;
	}

	public void setOrdinary_grouping_set(
			ordinary_grouping_set ordinary_grouping_set )
	{
		this.ordinary_grouping_set = ordinary_grouping_set;
	}

	public rollup_list getRollup_list( )
	{
		return rollup_list;
	}

	public void setRollup_list( rollup_list rollup_list )
	{
		this.rollup_list = rollup_list;
	}

	public cube_list getCube_list( )
	{
		return cube_list;
	}

	public void setCube_list( cube_list cube_list )
	{
		this.cube_list = cube_list;
	}

	public grouping_sets_specification getGrouping_sets_specification( )
	{
		return grouping_sets_specification;
	}

	public void setGrouping_sets_specification(
			grouping_sets_specification grouping_sets_specification )
	{
		this.grouping_sets_specification = grouping_sets_specification;
	}

	public empty_grouping_set getEmpty_grouping_set( )
	{
		return empty_grouping_set;
	}

	public void setEmpty_grouping_set( empty_grouping_set empty_grouping_set )
	{
		this.empty_grouping_set = empty_grouping_set;
	}

}
