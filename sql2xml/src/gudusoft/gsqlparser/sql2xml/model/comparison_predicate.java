package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class comparison_predicate
{
	@Element
	private row_value_predicand row_value_predicand;
	
	@Element
	private comparison_predicate_part_2 comparison_predicate_part_2;
}
