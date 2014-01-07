
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class insert_columns_and_source
{

	@Element(required = false)
	private from_subquery from_subquery;

	@Element(required = false)
	private from_constructor from_constructor;

	@Element(required = false)
	private from_default from_default;

	public from_subquery getFrom_subquery( )
	{
		return from_subquery;
	}

	public void setFrom_subquery( from_subquery from_subquery )
	{
		this.from_subquery = from_subquery;
	}

	public from_constructor getFrom_constructor( )
	{
		return from_constructor;
	}

	public void setFrom_constructor( from_constructor from_constructor )
	{
		this.from_constructor = from_constructor;
	}

	public from_default getFrom_default( )
	{
		return from_default;
	}

	public void setFrom_default( from_default from_default )
	{
		this.from_default = from_default;
	}

}
