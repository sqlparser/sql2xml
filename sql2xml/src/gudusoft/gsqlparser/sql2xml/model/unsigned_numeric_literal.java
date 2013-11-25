
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class unsigned_numeric_literal
{

	@Element(required = false)
	private String exact_numeric_literal;

	@Element(required = false)
	private String approximate_numeric_literal;

	public String getExact_numeric_literal( )
	{
		return exact_numeric_literal;
	}

	public void setExact_numeric_literal( String exact_numeric_literal )
	{
		this.exact_numeric_literal = exact_numeric_literal;
	}

	public String getApproximate_numeric_literal( )
	{
		return approximate_numeric_literal;
	}

	public void setApproximate_numeric_literal(
			String approximate_numeric_literal )
	{
		this.approximate_numeric_literal = approximate_numeric_literal;
	}

}
