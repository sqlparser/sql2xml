
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class numeric_value_expression
{

	@Element(required = false)
	private term term;

	@Element(required = false)
	private plus plus;

	@Element(required = false)
	private minus minus;

	public term getTerm( )
	{
		return term;
	}

	public void setTerm( term term )
	{
		this.term = term;
	}

	public plus getPlus( )
	{
		return plus;
	}

	public void setPlus( plus plus )
	{
		this.plus = plus;
	}

	public minus getMinus( )
	{
		return minus;
	}

	public void setMinus( minus minus )
	{
		this.minus = minus;
	}

}
