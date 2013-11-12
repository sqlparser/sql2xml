
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class direct_sql_data_statement
{

	@Element(required = false)
	private delete_statement_searched delete_statement_searched;

	@Element(required = false)
	private direct_select_statement_multiple_rows direct_select_statement_multiple_rows;

	@Element(required = false)
	private insert_statement insert_statement;

	@Element(required = false)
	private update_statement_searched update_statement_searched;

	@Element(required = false)
	private merge_statement merge_statement;

	@Element(required = false)
	private temporary_table_declaration temporary_table_declaration;
}
