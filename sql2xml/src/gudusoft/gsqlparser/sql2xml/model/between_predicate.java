
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class between_predicate
{

	@Element
	private row_value_predicand row_value_predicand = new row_value_predicand( );

	@Element
	private between_predicate_part_2 between_predicate_part_2 = new between_predicate_part_2( );

	public row_value_predicand getRow_value_predicand( )
	{
		return row_value_predicand;
	}

	public void setRow_value_predicand( row_value_predicand row_value_predicand )
	{
		this.row_value_predicand = row_value_predicand;
	}

	public between_predicate_part_2 getBetween_predicate_part_2( )
	{
		return between_predicate_part_2;
	}

	public void setBetween_predicate_part_2(
			between_predicate_part_2 between_predicate_part_2 )
	{
		this.between_predicate_part_2 = between_predicate_part_2;
	}

}
