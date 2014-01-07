
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class contextually_typed_row_value_expression
{

	@Element(required = false)
	private row_value_special_case row_value_special_case;

	@Element(required = false)
	private contextually_typed_row_value_constructor contextually_typed_row_value_constructor;

	public row_value_special_case getRow_value_special_case( )
	{
		return row_value_special_case;
	}

	public void setRow_value_special_case(
			row_value_special_case row_value_special_case )
	{
		this.row_value_special_case = row_value_special_case;
	}

	public contextually_typed_row_value_constructor getContextually_typed_row_value_constructor( )
	{
		return contextually_typed_row_value_constructor;
	}

	public void setContextually_typed_row_value_constructor(
			contextually_typed_row_value_constructor contextually_typed_row_value_constructor )
	{
		this.contextually_typed_row_value_constructor = contextually_typed_row_value_constructor;
	}

}
