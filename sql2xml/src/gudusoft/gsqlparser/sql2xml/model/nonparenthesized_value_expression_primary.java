package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class nonparenthesized_value_expression_primary
{
	@Element(required = false)
	private unsigned_value_specification unsigned_value_specification;
	
	@Element(required = false)
	private column_reference column_reference;
	
	@Element(required = false)
	private set_function_specification set_function_specification;
	
	@Element(required = false)
	private window_function window_function;
	
	@Element(required = false)
	private scalar_subquery scalar_subquery;
	
	@Element(required = false)
	private case_expression case_expression;
	
	@Element(required = false)
	private cast_specification cast_specification;
	
	@Element(required = false)
	private field_reference field_reference;
	
	@Element(required = false)
	private subtype_treatment subtype_treatment;
	
	@Element(required = false)
	private method_invocation method_invocation;
	
	@Element(required = false)
	private static_method_invocation static_method_invocation;
	
	@Element(required = false)
	private new_specification new_specification;
	
	@Element(required = false)
	private attribute_or_method_reference attribute_or_method_reference;
	
	@Element(required = false)
	private reference_resolution reference_resolution;
	
	@Element(required = false)
	private collection_value_constructor collection_value_constructor;
	
	@Element(required = false)
	private array_element_reference array_element_reference;
	
	@Element(required = false)
	private multiset_element_reference multiset_element_reference;
	
	@Element(required = false)
	private next_value_expression next_value_expression;
	
	@Element(required = false)
	private routine_invocation routine_invocation;
}
