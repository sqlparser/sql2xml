
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class general_set_function
{

	@Element
	private set_function_type set_function_type = new set_function_type( );

	@Element(required = false)
	private set_quantifier set_quantifier;

	@Element
	private value_expression value_expression = new value_expression( );

	public set_quantifier getSet_quantifier( )
	{
		return set_quantifier;
	}

	public void setSet_quantifier( set_quantifier set_quantifier )
	{
		this.set_quantifier = set_quantifier;
	}

	public set_function_type getSet_function_type( )
	{
		return set_function_type;
	}

	public value_expression getValue_expression( )
	{
		return value_expression;
	}

}
