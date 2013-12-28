
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class sql_schema_definition_statement
{

	@Element(required = false)
	private schema_definition schema_definition;

	@Element(required = false)
	private table_definition table_definition;

	@Element(required = false)
	private view_definition view_definition;

	@Element(required = false)
	private sql_invoked_routine sql_invoked_routine;

	@Element(required = false)
	private grant_statement grant_statement;

	@Element(required = false)
	private role_definition role_definition;

	@Element(required = false)
	private domain_definition domain_definition;

	@Element(required = false)
	private character_set_definition character_set_definition;

	@Element(required = false)
	private collation_definition collation_definition;

	@Element(required = false)
	private transliteration_definition transliteration_definition;

	@Element(required = false)
	private assertion_definition assertion_definition;

	@Element(required = false)
	private trigger_definition trigger_definition;

	@Element(required = false)
	private user_defined_type_definition user_defined_type_definition;

	@Element(required = false)
	private user_defined_cast_definition user_defined_cast_definition;

	@Element(required = false)
	private user_defined_ordering_definition user_defined_ordering_definition;

	@Element(required = false)
	private transform_definition transform_definition;

	@Element(required = false)
	private sequence_generator_definition sequence_generator_definition;

	public schema_definition getSchema_definition( )
	{
		return schema_definition;
	}

	public void setSchema_definition( schema_definition schema_definition )
	{
		this.schema_definition = schema_definition;
	}

	public table_definition getTable_definition( )
	{
		return table_definition;
	}

	public void setTable_definition( table_definition table_definition )
	{
		this.table_definition = table_definition;
	}

	public view_definition getView_definition( )
	{
		return view_definition;
	}

	public void setView_definition( view_definition view_definition )
	{
		this.view_definition = view_definition;
	}

	public sql_invoked_routine getSql_invoked_routine( )
	{
		return sql_invoked_routine;
	}

	public void setSql_invoked_routine( sql_invoked_routine sql_invoked_routine )
	{
		this.sql_invoked_routine = sql_invoked_routine;
	}

	public grant_statement getGrant_statement( )
	{
		return grant_statement;
	}

	public void setGrant_statement( grant_statement grant_statement )
	{
		this.grant_statement = grant_statement;
	}

	public role_definition getRole_definition( )
	{
		return role_definition;
	}

	public void setRole_definition( role_definition role_definition )
	{
		this.role_definition = role_definition;
	}

	public domain_definition getDomain_definition( )
	{
		return domain_definition;
	}

	public void setDomain_definition( domain_definition domain_definition )
	{
		this.domain_definition = domain_definition;
	}

	public character_set_definition getCharacter_set_definition( )
	{
		return character_set_definition;
	}

	public void setCharacter_set_definition(
			character_set_definition character_set_definition )
	{
		this.character_set_definition = character_set_definition;
	}

	public collation_definition getCollation_definition( )
	{
		return collation_definition;
	}

	public void setCollation_definition(
			collation_definition collation_definition )
	{
		this.collation_definition = collation_definition;
	}

	public transliteration_definition getTransliteration_definition( )
	{
		return transliteration_definition;
	}

	public void setTransliteration_definition(
			transliteration_definition transliteration_definition )
	{
		this.transliteration_definition = transliteration_definition;
	}

	public assertion_definition getAssertion_definition( )
	{
		return assertion_definition;
	}

	public void setAssertion_definition(
			assertion_definition assertion_definition )
	{
		this.assertion_definition = assertion_definition;
	}

	public trigger_definition getTrigger_definition( )
	{
		return trigger_definition;
	}

	public void setTrigger_definition( trigger_definition trigger_definition )
	{
		this.trigger_definition = trigger_definition;
	}

	public user_defined_type_definition getUser_defined_type_definition( )
	{
		return user_defined_type_definition;
	}

	public void setUser_defined_type_definition(
			user_defined_type_definition user_defined_type_definition )
	{
		this.user_defined_type_definition = user_defined_type_definition;
	}

	public user_defined_cast_definition getUser_defined_cast_definition( )
	{
		return user_defined_cast_definition;
	}

	public void setUser_defined_cast_definition(
			user_defined_cast_definition user_defined_cast_definition )
	{
		this.user_defined_cast_definition = user_defined_cast_definition;
	}

	public user_defined_ordering_definition getUser_defined_ordering_definition( )
	{
		return user_defined_ordering_definition;
	}

	public void setUser_defined_ordering_definition(
			user_defined_ordering_definition user_defined_ordering_definition )
	{
		this.user_defined_ordering_definition = user_defined_ordering_definition;
	}

	public transform_definition getTransform_definition( )
	{
		return transform_definition;
	}

	public void setTransform_definition(
			transform_definition transform_definition )
	{
		this.transform_definition = transform_definition;
	}

	public sequence_generator_definition getSequence_generator_definition( )
	{
		return sequence_generator_definition;
	}

	public void setSequence_generator_definition(
			sequence_generator_definition sequence_generator_definition )
	{
		this.sequence_generator_definition = sequence_generator_definition;
	}

}
