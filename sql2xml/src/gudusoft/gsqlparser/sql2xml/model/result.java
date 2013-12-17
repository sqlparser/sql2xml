
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class result
{

	@Element(required = false)
	private result_expression result_expression;

	@Element(required = false)
	private String kw_null;

	public result_expression getResult_expression( )
	{
		return result_expression;
	}

	public void setResult_expression( result_expression result_expression )
	{
		this.result_expression = result_expression;
	}

	public String getKw_null( )
	{
		return kw_null;
	}

	public void setKw_null( String kw_null )
	{
		this.kw_null = kw_null;
	}

}
