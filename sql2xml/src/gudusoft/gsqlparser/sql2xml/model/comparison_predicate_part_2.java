
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class comparison_predicate_part_2
{

	@Element
	private comp_op comp_op = new comp_op( );

	@Element
	private row_value_predicand row_value_predicand = new row_value_predicand( );

	public comp_op getComp_op( )
	{
		return comp_op;
	}

	public row_value_predicand getRow_value_predicand( )
	{
		return row_value_predicand;
	}

}
