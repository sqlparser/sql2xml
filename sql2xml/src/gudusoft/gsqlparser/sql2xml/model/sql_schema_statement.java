
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class sql_schema_statement
{

	@Element(required = false)
	private sql_schema_definition_statement sql_schema_definition_statement;

	@Element(required = false)
	private sql_schema_manipulation_statement sql_schema_manipulation_statement;

	public sql_schema_definition_statement getSql_schema_definition_statement( )
	{
		return sql_schema_definition_statement;
	}

	public void setSql_schema_definition_statement(
			sql_schema_definition_statement sql_schema_definition_statement )
	{
		this.sql_schema_definition_statement = sql_schema_definition_statement;
	}

	public sql_schema_manipulation_statement getSql_schema_manipulation_statement( )
	{
		return sql_schema_manipulation_statement;
	}

	public void setSql_schema_manipulation_statement(
			sql_schema_manipulation_statement sql_schema_manipulation_statement )
	{
		this.sql_schema_manipulation_statement = sql_schema_manipulation_statement;
	}

}
