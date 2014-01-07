
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class contextually_typed_row_value_constructor
{

	@Element(required = false)
	private common_value_expression common_value_expression;

	@Element(required = false)
	private boolean_value_expression boolean_value_expression;

	@Element(required = false)
	private contextually_typed_value_specification contextually_typed_value_specification;

	@Element(required = false)
	private contextually_typed_value_specification_with_paren contextually_typed_value_specification_with_paren;

	@Element(required = false)
	private contextually_typed_row_value_constructor_with_paren contextually_typed_row_value_constructor_with_paren;

	@Element(required = false)
	private contextually_typed_row_value_constructor_with_row contextually_typed_row_value_constructor_with_row;

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

	public contextually_typed_value_specification getContextually_typed_value_specification( )
	{
		return contextually_typed_value_specification;
	}

	public void setContextually_typed_value_specification(
			contextually_typed_value_specification contextually_typed_value_specification )
	{
		this.contextually_typed_value_specification = contextually_typed_value_specification;
	}

	public contextually_typed_value_specification_with_paren getContextually_typed_value_specification_with_paren( )
	{
		return contextually_typed_value_specification_with_paren;
	}

	public void setContextually_typed_value_specification_with_paren(
			contextually_typed_value_specification_with_paren contextually_typed_value_specification_with_paren )
	{
		this.contextually_typed_value_specification_with_paren = contextually_typed_value_specification_with_paren;
	}

	public contextually_typed_row_value_constructor_with_paren getContextually_typed_row_value_constructor_with_paren( )
	{
		return contextually_typed_row_value_constructor_with_paren;
	}

	public void setContextually_typed_row_value_constructor_with_paren(
			contextually_typed_row_value_constructor_with_paren contextually_typed_row_value_constructor_with_paren )
	{
		this.contextually_typed_row_value_constructor_with_paren = contextually_typed_row_value_constructor_with_paren;
	}

	public contextually_typed_row_value_constructor_with_row getContextually_typed_row_value_constructor_with_row( )
	{
		return contextually_typed_row_value_constructor_with_row;
	}

	public void setContextually_typed_row_value_constructor_with_row(
			contextually_typed_row_value_constructor_with_row contextually_typed_row_value_constructor_with_row )
	{
		this.contextually_typed_row_value_constructor_with_row = contextually_typed_row_value_constructor_with_row;
	}

}
