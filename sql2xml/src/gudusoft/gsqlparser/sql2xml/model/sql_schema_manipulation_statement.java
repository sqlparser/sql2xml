
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class sql_schema_manipulation_statement
{

	@Element(required = false)
	private drop_schema_statement drop_schema_statement;

	@Element(required = false)
	private alter_table_statement alter_table_statement;

	@Element(required = false)
	private drop_table_statement drop_table_statement;

	@Element(required = false)
	private drop_view_statement drop_view_statement;

	@Element(required = false)
	private alter_routine_statement alter_routine_statement;

	@Element(required = false)
	private drop_routine_statement drop_routine_statement;

	@Element(required = false)
	private drop_user_defined_cast_statement drop_user_defined_cast_statement;

	@Element(required = false)
	private revoke_statement revoke_statement;

	@Element(required = false)
	private drop_role_statement drop_role_statement;

	@Element(required = false)
	private alter_domain_statement alter_domain_statement;

	@Element(required = false)
	private drop_domain_statement drop_domain_statement;

	@Element(required = false)
	private drop_character_set_statement drop_character_set_statement;

	@Element(required = false)
	private drop_collation_statement drop_collation_statement;

	@Element(required = false)
	private drop_transliteration_statement drop_transliteration_statement;

	@Element(required = false)
	private drop_assertion_statement drop_assertion_statement;

	@Element(required = false)
	private drop_trigger_statement drop_trigger_statement;

	@Element(required = false)
	private alter_type_statement alter_type_statement;

	@Element(required = false)
	private drop_data_type_statement drop_data_type_statement;

	@Element(required = false)
	private drop_user_defined_ordering_statement drop_user_defined_ordering_statement;

	@Element(required = false)
	private alter_transform_statement alter_transform_statement;

	@Element(required = false)
	private drop_transform_statement drop_transform_statement;

	@Element(required = false)
	private alter_sequence_generator_statement alter_sequence_generator_statement;

	@Element(required = false)
	private drop_sequence_generator_statement drop_sequence_generator_statement;

	public drop_schema_statement getDrop_schema_statement( )
	{
		return drop_schema_statement;
	}

	public void setDrop_schema_statement(
			drop_schema_statement drop_schema_statement )
	{
		this.drop_schema_statement = drop_schema_statement;
	}

	public alter_table_statement getAlter_table_statement( )
	{
		return alter_table_statement;
	}

	public void setAlter_table_statement(
			alter_table_statement alter_table_statement )
	{
		this.alter_table_statement = alter_table_statement;
	}

	public drop_table_statement getDrop_table_statement( )
	{
		return drop_table_statement;
	}

	public void setDrop_table_statement(
			drop_table_statement drop_table_statement )
	{
		this.drop_table_statement = drop_table_statement;
	}

	public drop_view_statement getDrop_view_statement( )
	{
		return drop_view_statement;
	}

	public void setDrop_view_statement( drop_view_statement drop_view_statement )
	{
		this.drop_view_statement = drop_view_statement;
	}

	public alter_routine_statement getAlter_routine_statement( )
	{
		return alter_routine_statement;
	}

	public void setAlter_routine_statement(
			alter_routine_statement alter_routine_statement )
	{
		this.alter_routine_statement = alter_routine_statement;
	}

	public drop_routine_statement getDrop_routine_statement( )
	{
		return drop_routine_statement;
	}

	public void setDrop_routine_statement(
			drop_routine_statement drop_routine_statement )
	{
		this.drop_routine_statement = drop_routine_statement;
	}

	public drop_user_defined_cast_statement getDrop_user_defined_cast_statement( )
	{
		return drop_user_defined_cast_statement;
	}

	public void setDrop_user_defined_cast_statement(
			drop_user_defined_cast_statement drop_user_defined_cast_statement )
	{
		this.drop_user_defined_cast_statement = drop_user_defined_cast_statement;
	}

	public revoke_statement getRevoke_statement( )
	{
		return revoke_statement;
	}

	public void setRevoke_statement( revoke_statement revoke_statement )
	{
		this.revoke_statement = revoke_statement;
	}

	public drop_role_statement getDrop_role_statement( )
	{
		return drop_role_statement;
	}

	public void setDrop_role_statement( drop_role_statement drop_role_statement )
	{
		this.drop_role_statement = drop_role_statement;
	}

	public alter_domain_statement getAlter_domain_statement( )
	{
		return alter_domain_statement;
	}

	public void setAlter_domain_statement(
			alter_domain_statement alter_domain_statement )
	{
		this.alter_domain_statement = alter_domain_statement;
	}

	public drop_domain_statement getDrop_domain_statement( )
	{
		return drop_domain_statement;
	}

	public void setDrop_domain_statement(
			drop_domain_statement drop_domain_statement )
	{
		this.drop_domain_statement = drop_domain_statement;
	}

	public drop_character_set_statement getDrop_character_set_statement( )
	{
		return drop_character_set_statement;
	}

	public void setDrop_character_set_statement(
			drop_character_set_statement drop_character_set_statement )
	{
		this.drop_character_set_statement = drop_character_set_statement;
	}

	public drop_collation_statement getDrop_collation_statement( )
	{
		return drop_collation_statement;
	}

	public void setDrop_collation_statement(
			drop_collation_statement drop_collation_statement )
	{
		this.drop_collation_statement = drop_collation_statement;
	}

	public drop_transliteration_statement getDrop_transliteration_statement( )
	{
		return drop_transliteration_statement;
	}

	public void setDrop_transliteration_statement(
			drop_transliteration_statement drop_transliteration_statement )
	{
		this.drop_transliteration_statement = drop_transliteration_statement;
	}

	public drop_assertion_statement getDrop_assertion_statement( )
	{
		return drop_assertion_statement;
	}

	public void setDrop_assertion_statement(
			drop_assertion_statement drop_assertion_statement )
	{
		this.drop_assertion_statement = drop_assertion_statement;
	}

	public drop_trigger_statement getDrop_trigger_statement( )
	{
		return drop_trigger_statement;
	}

	public void setDrop_trigger_statement(
			drop_trigger_statement drop_trigger_statement )
	{
		this.drop_trigger_statement = drop_trigger_statement;
	}

	public alter_type_statement getAlter_type_statement( )
	{
		return alter_type_statement;
	}

	public void setAlter_type_statement(
			alter_type_statement alter_type_statement )
	{
		this.alter_type_statement = alter_type_statement;
	}

	public drop_data_type_statement getDrop_data_type_statement( )
	{
		return drop_data_type_statement;
	}

	public void setDrop_data_type_statement(
			drop_data_type_statement drop_data_type_statement )
	{
		this.drop_data_type_statement = drop_data_type_statement;
	}

	public drop_user_defined_ordering_statement getDrop_user_defined_ordering_statement( )
	{
		return drop_user_defined_ordering_statement;
	}

	public void setDrop_user_defined_ordering_statement(
			drop_user_defined_ordering_statement drop_user_defined_ordering_statement )
	{
		this.drop_user_defined_ordering_statement = drop_user_defined_ordering_statement;
	}

	public alter_transform_statement getAlter_transform_statement( )
	{
		return alter_transform_statement;
	}

	public void setAlter_transform_statement(
			alter_transform_statement alter_transform_statement )
	{
		this.alter_transform_statement = alter_transform_statement;
	}

	public drop_transform_statement getDrop_transform_statement( )
	{
		return drop_transform_statement;
	}

	public void setDrop_transform_statement(
			drop_transform_statement drop_transform_statement )
	{
		this.drop_transform_statement = drop_transform_statement;
	}

	public alter_sequence_generator_statement getAlter_sequence_generator_statement( )
	{
		return alter_sequence_generator_statement;
	}

	public void setAlter_sequence_generator_statement(
			alter_sequence_generator_statement alter_sequence_generator_statement )
	{
		this.alter_sequence_generator_statement = alter_sequence_generator_statement;
	}

	public drop_sequence_generator_statement getDrop_sequence_generator_statement( )
	{
		return drop_sequence_generator_statement;
	}

	public void setDrop_sequence_generator_statement(
			drop_sequence_generator_statement drop_sequence_generator_statement )
	{
		this.drop_sequence_generator_statement = drop_sequence_generator_statement;
	}

}
