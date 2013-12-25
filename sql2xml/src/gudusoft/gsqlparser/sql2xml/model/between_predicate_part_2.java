
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;

public class between_predicate_part_2
{

	@Element(required = false)
	private String kw_not;

	@Element
	private String kw_between = "between";

	@Element(required = false)
	private asymmetric_symmetric asymmetric_symmetric;

	@Path("row_value_predicand[1]")
	@Element(name = "row_value_special_case", required = false)
	private row_value_special_case left_row_value_special_case;

	@Path("row_value_predicand[1]")
	@Element(name = "row_value_constructor_predicand", required = false)
	private row_value_constructor_predicand left_row_value_constructor_predicand;

	@Element
	private String kw_and = "and";

	@Path("row_value_predicand[2]")
	@Element(name = "row_value_special_case", required = false)
	private row_value_special_case right_row_value_special_case;

	@Path("row_value_predicand[2]")
	@Element(name = "row_value_constructor_predicand", required = false)
	private row_value_constructor_predicand right_row_value_constructor_predicand;

	public String getKw_not( )
	{
		return kw_not;
	}

	public void setKw_not( String kw_not )
	{
		this.kw_not = kw_not;
	}

	public asymmetric_symmetric getAsymmetric_symmetric( )
	{
		return asymmetric_symmetric;
	}

	public void setAsymmetric_symmetric(
			asymmetric_symmetric asymmetric_symmetric )
	{
		this.asymmetric_symmetric = asymmetric_symmetric;
	}

	public row_value_special_case getLeft_row_value_special_case( )
	{
		return left_row_value_special_case;
	}

	public void setLeft_row_value_special_case(
			row_value_special_case left_row_value_special_case )
	{
		this.left_row_value_special_case = left_row_value_special_case;
	}

	public row_value_constructor_predicand getLeft_row_value_constructor_predicand( )
	{
		return left_row_value_constructor_predicand;
	}

	public void setLeft_row_value_constructor_predicand(
			row_value_constructor_predicand left_row_value_constructor_predicand )
	{
		this.left_row_value_constructor_predicand = left_row_value_constructor_predicand;
	}

	public row_value_special_case getRight_row_value_special_case( )
	{
		return right_row_value_special_case;
	}

	public void setRight_row_value_special_case(
			row_value_special_case right_row_value_special_case )
	{
		this.right_row_value_special_case = right_row_value_special_case;
	}

	public row_value_constructor_predicand getRight_row_value_constructor_predicand( )
	{
		return right_row_value_constructor_predicand;
	}

	public void setRight_row_value_constructor_predicand(
			row_value_constructor_predicand right_row_value_constructor_predicand )
	{
		this.right_row_value_constructor_predicand = right_row_value_constructor_predicand;
	}

}
