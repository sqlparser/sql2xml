package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class directly_executable_statement
{
	@Element(required=false)
	private direct_sql_data_statement direct_sql_data_statement;
	
	@Element(required=false)
	private sql_schema_statement sql_schema_statement;
	
	@Element(required=false)
	private sql_transaction_statement sql_transaction_statement;
	
	@Element(required=false)
	private sql_connection_statement sql_connection_statement;
	
	@Element(required=false)
	private sql_session_statement sql_session_statement;
	
	@Element(required=false)
	private direct_implementation_defined_statement direct_implementation_defined_statement;
}
