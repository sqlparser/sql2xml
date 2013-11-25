
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

	public unsigned_value_specification getUnsigned_value_specification( )
	{
		return unsigned_value_specification;
	}

	public void setUnsigned_value_specification(
			unsigned_value_specification unsigned_value_specification )
	{
		this.unsigned_value_specification = unsigned_value_specification;
	}

	public column_reference getColumn_reference( )
	{
		return column_reference;
	}

	public void setColumn_reference( column_reference column_reference )
	{
		this.column_reference = column_reference;
	}

	public set_function_specification getSet_function_specification( )
	{
		return set_function_specification;
	}

	public void setSet_function_specification(
			set_function_specification set_function_specification )
	{
		this.set_function_specification = set_function_specification;
	}

	public window_function getWindow_function( )
	{
		return window_function;
	}

	public void setWindow_function( window_function window_function )
	{
		this.window_function = window_function;
	}

	public scalar_subquery getScalar_subquery( )
	{
		return scalar_subquery;
	}

	public void setScalar_subquery( scalar_subquery scalar_subquery )
	{
		this.scalar_subquery = scalar_subquery;
	}

	public case_expression getCase_expression( )
	{
		return case_expression;
	}

	public void setCase_expression( case_expression case_expression )
	{
		this.case_expression = case_expression;
	}

	public cast_specification getCast_specification( )
	{
		return cast_specification;
	}

	public void setCast_specification( cast_specification cast_specification )
	{
		this.cast_specification = cast_specification;
	}

	public field_reference getField_reference( )
	{
		return field_reference;
	}

	public void setField_reference( field_reference field_reference )
	{
		this.field_reference = field_reference;
	}

	public subtype_treatment getSubtype_treatment( )
	{
		return subtype_treatment;
	}

	public void setSubtype_treatment( subtype_treatment subtype_treatment )
	{
		this.subtype_treatment = subtype_treatment;
	}

	public method_invocation getMethod_invocation( )
	{
		return method_invocation;
	}

	public void setMethod_invocation( method_invocation method_invocation )
	{
		this.method_invocation = method_invocation;
	}

	public static_method_invocation getStatic_method_invocation( )
	{
		return static_method_invocation;
	}

	public void setStatic_method_invocation(
			static_method_invocation static_method_invocation )
	{
		this.static_method_invocation = static_method_invocation;
	}

	public new_specification getNew_specification( )
	{
		return new_specification;
	}

	public void setNew_specification( new_specification new_specification )
	{
		this.new_specification = new_specification;
	}

	public attribute_or_method_reference getAttribute_or_method_reference( )
	{
		return attribute_or_method_reference;
	}

	public void setAttribute_or_method_reference(
			attribute_or_method_reference attribute_or_method_reference )
	{
		this.attribute_or_method_reference = attribute_or_method_reference;
	}

	public reference_resolution getReference_resolution( )
	{
		return reference_resolution;
	}

	public void setReference_resolution(
			reference_resolution reference_resolution )
	{
		this.reference_resolution = reference_resolution;
	}

	public collection_value_constructor getCollection_value_constructor( )
	{
		return collection_value_constructor;
	}

	public void setCollection_value_constructor(
			collection_value_constructor collection_value_constructor )
	{
		this.collection_value_constructor = collection_value_constructor;
	}

	public array_element_reference getArray_element_reference( )
	{
		return array_element_reference;
	}

	public void setArray_element_reference(
			array_element_reference array_element_reference )
	{
		this.array_element_reference = array_element_reference;
	}

	public multiset_element_reference getMultiset_element_reference( )
	{
		return multiset_element_reference;
	}

	public void setMultiset_element_reference(
			multiset_element_reference multiset_element_reference )
	{
		this.multiset_element_reference = multiset_element_reference;
	}

	public next_value_expression getNext_value_expression( )
	{
		return next_value_expression;
	}

	public void setNext_value_expression(
			next_value_expression next_value_expression )
	{
		this.next_value_expression = next_value_expression;
	}

	public routine_invocation getRoutine_invocation( )
	{
		return routine_invocation;
	}

	public void setRoutine_invocation( routine_invocation routine_invocation )
	{
		this.routine_invocation = routine_invocation;
	}

}
