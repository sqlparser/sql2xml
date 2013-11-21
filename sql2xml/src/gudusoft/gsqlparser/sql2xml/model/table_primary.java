
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class table_primary
{

	@Element(required = false)
	private table_or_query_name_as_correlation_name table_or_query_name_as_correlation_name;

	@Element(required = false)
	private derived_table_as_correlation_name derived_table_as_correlation_name;

	@Element(required = false)
	private lateral_derived_table_as_correlation_name lateral_derived_table_as_correlation_name;

	@Element(required = false)
	private collection_derived_table_as_correction_name collection_derived_table_as_correction_name;

	@Element(required = false)
	private table_function_derived_table_as_correction_name table_function_derived_table_as_correction_name;

	@Element(required = false)
	private only_spec_as_correction_name only_spec_as_correction_name;

	@Element(required = false)
	private parenthesized_joined_table parenthesized_joined_table;

	public table_or_query_name_as_correlation_name getTable_or_query_name_as_correlation_name( )
	{
		return table_or_query_name_as_correlation_name;
	}

	public void setTable_or_query_name_as_correlation_name(
			table_or_query_name_as_correlation_name table_or_query_name_as_correlation_name )
	{
		this.table_or_query_name_as_correlation_name = table_or_query_name_as_correlation_name;
	}

	public derived_table_as_correlation_name getDerived_table_as_correlation_name( )
	{
		return derived_table_as_correlation_name;
	}

	public void setDerived_table_as_correlation_name(
			derived_table_as_correlation_name derived_table_as_correlation_name )
	{
		this.derived_table_as_correlation_name = derived_table_as_correlation_name;
	}

	public lateral_derived_table_as_correlation_name getLateral_derived_table_as_correlation_name( )
	{
		return lateral_derived_table_as_correlation_name;
	}

	public void setLateral_derived_table_as_correlation_name(
			lateral_derived_table_as_correlation_name lateral_derived_table_as_correlation_name )
	{
		this.lateral_derived_table_as_correlation_name = lateral_derived_table_as_correlation_name;
	}

	public collection_derived_table_as_correction_name getCollection_derived_table_as_correction_name( )
	{
		return collection_derived_table_as_correction_name;
	}

	public void setCollection_derived_table_as_correction_name(
			collection_derived_table_as_correction_name collection_derived_table_as_correction_name )
	{
		this.collection_derived_table_as_correction_name = collection_derived_table_as_correction_name;
	}

	public table_function_derived_table_as_correction_name getTable_function_derived_table_as_correction_name( )
	{
		return table_function_derived_table_as_correction_name;
	}

	public void setTable_function_derived_table_as_correction_name(
			table_function_derived_table_as_correction_name table_function_derived_table_as_correction_name )
	{
		this.table_function_derived_table_as_correction_name = table_function_derived_table_as_correction_name;
	}

	public only_spec_as_correction_name getOnly_spec_as_correction_name( )
	{
		return only_spec_as_correction_name;
	}

	public void setOnly_spec_as_correction_name(
			only_spec_as_correction_name only_spec_as_correction_name )
	{
		this.only_spec_as_correction_name = only_spec_as_correction_name;
	}

	public parenthesized_joined_table getParenthesized_joined_table( )
	{
		return parenthesized_joined_table;
	}

	public void setParenthesized_joined_table(
			parenthesized_joined_table parenthesized_joined_table )
	{
		this.parenthesized_joined_table = parenthesized_joined_table;
	}

}
