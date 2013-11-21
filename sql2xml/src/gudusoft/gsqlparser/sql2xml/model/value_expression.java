
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class value_expression
{

	@Element(required = false)
	private common_value_expression common_value_expression;

	@Element(required = false)
	private boolean_value_expression boolean_value_expression;

	@Element(required = false)
	private row_value_expression row_value_expression;

	public common_value_expression getCommon_value_expression( )
	{
		return common_value_expression;
	}

	public void setCommon_value_expression(
			common_value_expression common_value_expression )
	{
		this.common_value_expression = common_value_expression;
	}

	public boolean_value_expression getBoolean_value_expression( )
	{
		return boolean_value_expression;
	}

	public void setBoolean_value_expression(
			boolean_value_expression boolean_value_expression )
	{
		this.boolean_value_expression = boolean_value_expression;
	}

	public row_value_expression getRow_value_expression( )
	{
		return row_value_expression;
	}

	public void setRow_value_expression(
			row_value_expression row_value_expression )
	{
		this.row_value_expression = row_value_expression;
	}

}
