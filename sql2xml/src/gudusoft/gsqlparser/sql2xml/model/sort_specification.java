
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class sort_specification
{

	@Element
	private sort_key sort_key = new sort_key( );

	@Element(required = false)
	private ordering_specification ordering_specification;

	@Element(required = false)
	private null_ordering null_ordering;

	public sort_key getSort_key( )
	{
		return sort_key;
	}

	public ordering_specification getOrdering_specification( )
	{
		return ordering_specification;
	}

	public void setOrdering_specification(
			ordering_specification ordering_specification )
	{
		this.ordering_specification = ordering_specification;
	}

	public null_ordering getNull_ordering( )
	{
		return null_ordering;
	}

	public void setNull_ordering( null_ordering null_ordering )
	{
		this.null_ordering = null_ordering;
	}

}
