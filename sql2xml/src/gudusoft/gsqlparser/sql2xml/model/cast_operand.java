
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class cast_operand
{

	@Element(required = false)
	private value_expression value_expression;

	@Element(required = false)
	private implicitly_typed_value_specification implicitly_typed_value_specification;

	public value_expression getValue_expression( )
	{
		return value_expression;
	}

	public void setValue_expression( value_expression value_expression )
	{
		this.value_expression = value_expression;
	}

	public implicitly_typed_value_specification getImplicitly_typed_value_specification( )
	{
		return implicitly_typed_value_specification;
	}

	public void setImplicitly_typed_value_specification(
			implicitly_typed_value_specification implicitly_typed_value_specification )
	{
		this.implicitly_typed_value_specification = implicitly_typed_value_specification;
	}

}
