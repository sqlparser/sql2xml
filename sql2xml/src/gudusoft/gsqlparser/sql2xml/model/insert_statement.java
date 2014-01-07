
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class insert_statement
{

	@Element
	private String kw_insert = "insert";

	@Element
	private String kw_into = "into";

	@Element
	private insertion_target insertion_target = new insertion_target( );
	
	@Element
	private insert_columns_and_source insert_columns_and_source = new insert_columns_and_source( );

	
	public insertion_target getInsertion_target( )
	{
		return insertion_target;
	}

	
	public insert_columns_and_source getInsert_columns_and_source( )
	{
		return insert_columns_and_source;
	}
	
	
}
