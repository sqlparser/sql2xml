
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class column_definition
{

	@Element
	private column_name column_name = new column_name( );

	@Element(required = false)
	private data_type_or_domain_name data_type_or_domain_name;

	@Element(required = false)
	private default_clause_identity_column_specification_generation_clause default_clause_identity_column_specification_generation_clause;

	@Element(required = false)
	private column_constraint_definition_list column_constraint_definition_list;

	@Element(required = false)
	private collate_clause collate_clause;

	public void setCollate_clause( collate_clause collate_clause )
	{
		this.collate_clause = collate_clause;
	}

	public data_type_or_domain_name getData_type_or_domain_name( )
	{
		return data_type_or_domain_name;
	}

	public void setData_type_or_domain_name(
			data_type_or_domain_name data_type_or_domain_name )
	{
		this.data_type_or_domain_name = data_type_or_domain_name;
	}

	public default_clause_identity_column_specification_generation_clause getDefault_clause_identity_column_specification_generation_clause( )
	{
		return default_clause_identity_column_specification_generation_clause;
	}

	public void setDefault_clause_identity_column_specification_generation_clause(
			default_clause_identity_column_specification_generation_clause default_clause_identity_column_specification_generation_clause )
	{
		this.default_clause_identity_column_specification_generation_clause = default_clause_identity_column_specification_generation_clause;
	}

	public column_constraint_definition_list getColumn_constraint_definition_list( )
	{
		return column_constraint_definition_list;
	}

	public void setColumn_constraint_definition_list(
			column_constraint_definition_list column_constraint_definition_list )
	{
		this.column_constraint_definition_list = column_constraint_definition_list;
	}

	public column_name getColumn_name( )
	{
		return column_name;
	}

	public collate_clause getCollate_clause( )
	{
		return collate_clause;
	}

}
