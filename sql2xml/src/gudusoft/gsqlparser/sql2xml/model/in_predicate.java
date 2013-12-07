
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class in_predicate
{

	@Element
	private row_value_predicand row_value_predicand = new row_value_predicand( );

	@Element
	private in_predicate_part_2 in_predicate_part_2 = new in_predicate_part_2( );

	public row_value_predicand getRow_value_predicand( )
	{
		return row_value_predicand;
	}

	public in_predicate_part_2 getIn_predicate_part_2( )
	{
		return in_predicate_part_2;
	}

}
