package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class comparison_predicate_part_2
{
	@Element
	private comp_op comp_op;
	
	@Element
	private row_value_predicand row_value_predicand;
}
