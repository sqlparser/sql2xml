
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class comp_op
{

	@Element(required = false)
	private String equals_operator;

	@Element(required = false)
	private String not_equals_operator;

	@Element(required = false)
	private String less_than_operator;

	@Element(required = false)
	private String greater_than_operator;

	@Element(required = false)
	private String less_than_or_equals_operator;

	@Element(required = false)
	private String greater_than_or_equals_operator;

	public String getEquals_operator( )
	{
		return equals_operator;
	}

	public void setEquals_operator( String equals_operator )
	{
		this.equals_operator = equals_operator;
	}

	public String getNot_equals_operator( )
	{
		return not_equals_operator;
	}

	public void setNot_equals_operator( String not_equals_operator )
	{
		this.not_equals_operator = not_equals_operator;
	}

	public String getLess_than_operator( )
	{
		return less_than_operator;
	}

	public void setLess_than_operator( String less_than_operator )
	{
		this.less_than_operator = less_than_operator;
	}

	public String getGreater_than_operator( )
	{
		return greater_than_operator;
	}

	public void setGreater_than_operator( String greater_than_operator )
	{
		this.greater_than_operator = greater_than_operator;
	}

	public String getLess_than_or_equals_operator( )
	{
		return less_than_or_equals_operator;
	}

	public void setLess_than_or_equals_operator(
			String less_than_or_equals_operator )
	{
		this.less_than_or_equals_operator = less_than_or_equals_operator;
	}

	public String getGreater_than_or_equals_operator( )
	{
		return greater_than_or_equals_operator;
	}

	public void setGreater_than_or_equals_operator(
			String greater_than_or_equals_operator )
	{
		this.greater_than_or_equals_operator = greater_than_or_equals_operator;
	}

}
