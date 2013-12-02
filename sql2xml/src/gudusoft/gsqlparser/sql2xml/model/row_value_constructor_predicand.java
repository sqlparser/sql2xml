
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class row_value_constructor_predicand
{

	@Element(required = false)
	private common_value_expression common_value_expression;

	@Element(required = false)
	private boolean_predicand boolean_predicand;

	@Element(required = false)
	private explicit_row_value_constructor explicit_row_value_constructor;

	public common_value_expression getCommon_value_expression( )
	{
		return common_value_expression;
	}

	public void setCommon_value_expression(
			common_value_expression common_value_expression )
	{
		this.common_value_expression = common_value_expression;
	}

	public boolean_predicand getBoolean_predicand( )
	{
		return boolean_predicand;
	}

	public void setBoolean_predicand( boolean_predicand boolean_predicand )
	{
		this.boolean_predicand = boolean_predicand;
	}

	public explicit_row_value_constructor getExplicit_row_value_constructor( )
	{
		return explicit_row_value_constructor;
	}

	public void setExplicit_row_value_constructor(
			explicit_row_value_constructor explicit_row_value_constructor )
	{
		this.explicit_row_value_constructor = explicit_row_value_constructor;
	}

}
