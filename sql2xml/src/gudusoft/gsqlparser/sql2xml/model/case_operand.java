
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class case_operand
{

	@Element(required = false)
	private row_value_predicand row_value_predicand;

	@Element(required = false)
	private overlaps_predicate_part_1 overlaps_predicate_part_1;

	public row_value_predicand getRow_value_predicand( )
	{
		return row_value_predicand;
	}

	public void setRow_value_predicand( row_value_predicand row_value_predicand )
	{
		this.row_value_predicand = row_value_predicand;
	}

	public overlaps_predicate_part_1 getOverlaps_predicate_part_1( )
	{
		return overlaps_predicate_part_1;
	}

	public void setOverlaps_predicate_part_1(
			overlaps_predicate_part_1 overlaps_predicate_part_1 )
	{
		this.overlaps_predicate_part_1 = overlaps_predicate_part_1;
	}

}
