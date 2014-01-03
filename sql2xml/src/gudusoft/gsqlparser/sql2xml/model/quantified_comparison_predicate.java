
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class quantified_comparison_predicate
{

	@Element
	private row_value_predicand row_value_predicand = new row_value_predicand( );

	@Element
	private quantified_comparison_predicate_part_2 quantified_comparison_predicate_part_2 = new quantified_comparison_predicate_part_2( );

	public row_value_predicand getRow_value_predicand( )
	{
		return row_value_predicand;
	}

	public quantified_comparison_predicate_part_2 getQuantified_comparison_predicate_part_2( )
	{
		return quantified_comparison_predicate_part_2;
	}

}
