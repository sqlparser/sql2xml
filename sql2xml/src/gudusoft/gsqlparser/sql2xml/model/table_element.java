
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class table_element
{

	@Element(required = false)
	private column_definition column_definition;

	@Element(required = false)
	private table_constraint_definition table_constraint_definition;

	@Element(required = false)
	private like_clause like_clause;

	public column_definition getColumn_definition( )
	{
		return column_definition;
	}

	public void setColumn_definition( column_definition column_definition )
	{
		this.column_definition = column_definition;
	}

	public table_constraint_definition getTable_constraint_definition( )
	{
		return table_constraint_definition;
	}

	public void setTable_constraint_definition(
			table_constraint_definition table_constraint_definition )
	{
		this.table_constraint_definition = table_constraint_definition;
	}

	public like_clause getLike_clause( )
	{
		return like_clause;
	}

	public void setLike_clause( like_clause like_clause )
	{
		this.like_clause = like_clause;
	}

}
