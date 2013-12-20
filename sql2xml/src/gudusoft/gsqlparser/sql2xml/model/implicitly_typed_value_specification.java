
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class implicitly_typed_value_specification
{

	@Element(required = false)
	private null_specification null_specification;

	@Element(required = false)
	private empty_specification empty_specification;

	public null_specification getNull_specification( )
	{
		return null_specification;
	}

	public void setNull_specification( null_specification null_specification )
	{
		this.null_specification = null_specification;
	}

	public empty_specification getEmpty_specification( )
	{
		return empty_specification;
	}

	public void setEmpty_specification( empty_specification empty_specification )
	{
		this.empty_specification = empty_specification;
	}

}
