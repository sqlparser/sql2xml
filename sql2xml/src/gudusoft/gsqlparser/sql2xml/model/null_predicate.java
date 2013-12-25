
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class null_predicate
{

	@Element
	private row_value_predicand row_value_predicand = new row_value_predicand( );

	@Element
	private null_predicate_part_2 null_predicate_part_2 = new null_predicate_part_2( );

	public row_value_predicand getRow_value_predicand( )
	{
		return row_value_predicand;
	}

	public void setRow_value_predicand( row_value_predicand row_value_predicand )
	{
		this.row_value_predicand = row_value_predicand;
	}

	public null_predicate_part_2 getNull_predicate_part_2( )
	{
		return null_predicate_part_2;
	}

	public void setNull_predicate_part_2(
			null_predicate_part_2 null_predicate_part_2 )
	{
		this.null_predicate_part_2 = null_predicate_part_2;
	}

}
