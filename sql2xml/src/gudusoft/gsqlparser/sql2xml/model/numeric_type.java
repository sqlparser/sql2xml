
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class numeric_type
{

	@Element(required = false)
	private exact_numeric_type exact_numeric_type;

	@Element(required = false)
	private approximate_numeric_type approximate_numeric_type;

	public exact_numeric_type getExact_numeric_type( )
	{
		return exact_numeric_type;
	}

	public void setExact_numeric_type( exact_numeric_type exact_numeric_type )
	{
		this.exact_numeric_type = exact_numeric_type;
	}

	public approximate_numeric_type getApproximate_numeric_type( )
	{
		return approximate_numeric_type;
	}

	public void setApproximate_numeric_type(
			approximate_numeric_type approximate_numeric_type )
	{
		this.approximate_numeric_type = approximate_numeric_type;
	}

}
