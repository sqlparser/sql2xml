
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class add_table_constraint_definition
{

	@Element
	private String kw_add = "add";

	@Element
	private table_constraint_definition table_constraint_definition = new table_constraint_definition( );

	public table_constraint_definition getTable_constraint_definition( )
	{
		return table_constraint_definition;
	}

}
