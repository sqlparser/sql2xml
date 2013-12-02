
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class comparison_predicate
{

	@Element
	private row_value_predicand row_value_predicand = new row_value_predicand( );

	@Element
	private comparison_predicate_part_2 comparison_predicate_part_2 = new comparison_predicate_part_2( );

	public row_value_predicand getRow_value_predicand( )
	{
		return row_value_predicand;
	}

	public comparison_predicate_part_2 getComparison_predicate_part_2( )
	{
		return comparison_predicate_part_2;
	}

}
