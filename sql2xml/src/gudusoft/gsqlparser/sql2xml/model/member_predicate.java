
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class member_predicate
{

	@Element
	private row_value_predicand row_value_predicand = new row_value_predicand( );

	@Element
	private member_predicate_part_2 member_predicate_part_2 = new member_predicate_part_2( );

	public row_value_predicand getRow_value_predicand( )
	{
		return row_value_predicand;
	}

	public member_predicate_part_2 getMember_predicate_part_2( )
	{
		return member_predicate_part_2;
	}

}
