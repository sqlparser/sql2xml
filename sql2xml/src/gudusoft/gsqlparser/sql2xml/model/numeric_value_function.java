package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class numeric_value_function
{
	@Element(required = false)
	private position_expression position_expression;
	
	@Element(required = false)
	private regex_occurrences_function regex_occurrences_function;
	
	@Element(required = false)
	private regex_position_expression regex_position_expression;
	
	@Element(required = false)
	private extract_expression extract_expression;
	
	@Element(required = false)
	private length_expression length_expression;
	
	@Element(required = false)
	private cardinality_expression cardinality_expression;
	
	@Element(required = false)
	private absolute_value_expression absolute_value_expression;
	
	@Element(required = false)
	private modulus_expression modulus_expression;
	
	@Element(required = false)
	private natural_logarithm natural_logarithm;
	
	@Element(required = false)
	private exponential_function exponential_function;
	
	@Element(required = false)
	private power_function power_function;
	
	@Element(required = false)
	private square_root square_root;
	
	@Element(required = false)
	private floor_function floor_function;
	
	@Element(required = false)
	private ceiling_function ceiling_function;
	
	@Element(required = false)
	private width_bucket_function width_bucket_function;
}
