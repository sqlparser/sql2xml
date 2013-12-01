
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class normalize_function
{

	@Element
	private String kw_normalize = "normalize";

	@Element
	private character_value_expression character_value_expression = new character_value_expression( );

	@Element(required = false)
	private normal_form_function_result_length normal_form_function_result_length;

	public normal_form_function_result_length getNormal_form_function_result_length( )
	{
		return normal_form_function_result_length;
	}

	public void setNormal_form_function_result_length(
			normal_form_function_result_length normal_form_function_result_length )
	{
		this.normal_form_function_result_length = normal_form_function_result_length;
	}

	public character_value_expression getCharacter_value_expression( )
	{
		return character_value_expression;
	}

}
