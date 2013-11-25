
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class row_value_expression
{

	@Element(required = false)
	private row_value_special_case row_value_special_case;

	@Element(required = false)
	private explicit_row_value_constructor explicit_row_value_constructor;

	public row_value_special_case getRow_value_special_case( )
	{
		return row_value_special_case;
	}

	public void setRow_value_special_case(
			row_value_special_case row_value_special_case )
	{
		this.row_value_special_case = row_value_special_case;
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
