
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class directly_executable_statement
{

	@Element(required = false)
	private direct_sql_data_statement direct_sql_data_statement;

	@Element(required = false)
	private sql_schema_statement sql_schema_statement;

	@Element(required = false)
	private sql_transaction_statement sql_transaction_statement;

	@Element(required = false)
	private sql_connection_statement sql_connection_statement;

	@Element(required = false)
	private sql_session_statement sql_session_statement;

	@Element(required = false)
	private String direct_implementation_defined_statement;

	public direct_sql_data_statement getDirect_sql_data_statement( )
	{
		return direct_sql_data_statement;
	}

	public void setDirect_sql_data_statement(
			direct_sql_data_statement direct_sql_data_statement )
	{
		this.direct_sql_data_statement = direct_sql_data_statement;
	}

	public sql_schema_statement getSql_schema_statement( )
	{
		return sql_schema_statement;
	}

	public void setSql_schema_statement(
			sql_schema_statement sql_schema_statement )
	{
		this.sql_schema_statement = sql_schema_statement;
	}

	public sql_transaction_statement getSql_transaction_statement( )
	{
		return sql_transaction_statement;
	}

	public void setSql_transaction_statement(
			sql_transaction_statement sql_transaction_statement )
	{
		this.sql_transaction_statement = sql_transaction_statement;
	}

	public sql_connection_statement getSql_connection_statement( )
	{
		return sql_connection_statement;
	}

	public void setSql_connection_statement(
			sql_connection_statement sql_connection_statement )
	{
		this.sql_connection_statement = sql_connection_statement;
	}

	public sql_session_statement getSql_session_statement( )
	{
		return sql_session_statement;
	}

	public void setSql_session_statement(
			sql_session_statement sql_session_statement )
	{
		this.sql_session_statement = sql_session_statement;
	}

	public String getDirect_implementation_defined_statement( )
	{
		return direct_implementation_defined_statement;
	}

	public void setDirect_implementation_defined_statement(
			String direct_implementation_defined_statement )
	{
		this.direct_implementation_defined_statement = direct_implementation_defined_statement;
	}

}
