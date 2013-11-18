
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

	public delete_statement_searched getDelete_statement_searched( )
	{
		return delete_statement_searched;
	}

	public void setDelete_statement_searched(
			delete_statement_searched delete_statement_searched )
	{
		this.delete_statement_searched = delete_statement_searched;
	}

	public direct_select_statement_multiple_rows getDirect_select_statement_multiple_rows( )
	{
		return direct_select_statement_multiple_rows;
	}

	public void setDirect_select_statement_multiple_rows(
			direct_select_statement_multiple_rows direct_select_statement_multiple_rows )
	{
		this.direct_select_statement_multiple_rows = direct_select_statement_multiple_rows;
	}

	public insert_statement getInsert_statement( )
	{
		return insert_statement;
	}

	public void setInsert_statement( insert_statement insert_statement )
	{
		this.insert_statement = insert_statement;
	}

	public update_statement_searched getUpdate_statement_searched( )
	{
		return update_statement_searched;
	}

	public void setUpdate_statement_searched(
			update_statement_searched update_statement_searched )
	{
		this.update_statement_searched = update_statement_searched;
	}

	public merge_statement getMerge_statement( )
	{
		return merge_statement;
	}

	public void setMerge_statement( merge_statement merge_statement )
	{
		this.merge_statement = merge_statement;
	}

	public temporary_table_declaration getTemporary_table_declaration( )
	{
		return temporary_table_declaration;
	}

	public void setTemporary_table_declaration(
			temporary_table_declaration temporary_table_declaration )
	{
		this.temporary_table_declaration = temporary_table_declaration;
	}
}
