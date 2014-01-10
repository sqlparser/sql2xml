
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class alter_table_statement
{

	@Element
	private String kw_alter = "alter";

	@Element
	private String kw_table = "table";

	@Element
	private table_name table_name = new table_name( );

	@Element
	private alter_table_action alter_table_action = new alter_table_action( );

	public String getKw_alter( )
	{
		return kw_alter;
	}

	public String getKw_table( )
	{
		return kw_table;
	}

	public table_name getTable_name( )
	{
		return table_name;
	}

	public alter_table_action getAlter_table_action( )
	{
		return alter_table_action;
	}

}
