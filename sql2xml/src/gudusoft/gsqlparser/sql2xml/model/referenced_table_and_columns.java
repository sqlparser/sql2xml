
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class referenced_table_and_columns
{

	@Element
	private table_name table_name = new table_name( );

	@Element(required = false)
	private reference_column_list reference_column_list;

	public reference_column_list getReference_column_list( )
	{
		return reference_column_list;
	}

	public void setReference_column_list(
			reference_column_list reference_column_list )
	{
		this.reference_column_list = reference_column_list;
	}

	public table_name getTable_name( )
	{
		return table_name;
	}

}
