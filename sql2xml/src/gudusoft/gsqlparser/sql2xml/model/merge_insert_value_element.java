
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class merge_insert_value_element
{

	@Element(required = false)
	private value_expression value_expression;

	@Element(required = false)
	private contextually_typed_value_specification contextually_typed_value_specification;

	public value_expression getValue_expression( )
	{
		return value_expression;
	}

	public void setValue_expression( value_expression value_expression )
	{
		this.value_expression = value_expression;
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

}
