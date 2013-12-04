
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class grouping_column_reference
{

	@Element
	private column_reference column_reference = new column_reference( );

	@Element(required = false)
	private collate_clause collate_clause;

	public collate_clause getCollate_clause( )
	{
		return collate_clause;
	}

	public void setCollate_clause( collate_clause collate_clause )
	{
		this.collate_clause = collate_clause;
	}

	public column_reference getColumn_reference( )
	{
		return column_reference;
	}

}
