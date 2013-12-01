
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class normal_form_function_result_length
{

	@Element
	private normal_form normal_form = new normal_form( );

	@Element(required = false)
	private normalize_function_result_length normalize_function_result_length;

	public normalize_function_result_length getNormalize_function_result_length( )
	{
		return normalize_function_result_length;
	}

	public void setNormalize_function_result_length(
			normalize_function_result_length normalize_function_result_length )
	{
		this.normalize_function_result_length = normalize_function_result_length;
	}

	public normal_form getNormal_form( )
	{
		return normal_form;
	}

}
