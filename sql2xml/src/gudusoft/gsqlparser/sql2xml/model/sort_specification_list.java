
package gudusoft.gsqlparser.sql2xml.model;

import java.util.List;

import org.simpleframework.xml.ElementList;

public class sort_specification_list
{

	@ElementList(entry = "sort_specification", inline = true)
	private List<sort_specification> sort_specification;

	public List<sort_specification> getSort_specification( )
	{
		return sort_specification;
	}

	public void setSort_specification(
			List<sort_specification> sort_specification )
	{
		this.sort_specification = sort_specification;
	}
}
