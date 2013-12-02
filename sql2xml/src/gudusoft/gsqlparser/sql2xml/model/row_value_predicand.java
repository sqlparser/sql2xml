
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class row_value_predicand
{

	@Element(required = false)
	private row_value_special_case row_value_special_case;

	@Element(required = false)
	private row_value_constructor_predicand row_value_constructor_predicand;

	public row_value_special_case getRow_value_special_case( )
	{
		return row_value_special_case;
	}

	public void setRow_value_special_case(
			row_value_special_case row_value_special_case )
	{
		this.row_value_special_case = row_value_special_case;
	}

	public row_value_constructor_predicand getRow_value_constructor_predicand( )
	{
		return row_value_constructor_predicand;
	}

	public void setRow_value_constructor_predicand(
			row_value_constructor_predicand row_value_constructor_predicand )
	{
		this.row_value_constructor_predicand = row_value_constructor_predicand;
	}

}
