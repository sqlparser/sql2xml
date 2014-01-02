
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class as_subquery_clause
{

	@Element(required = false)
	private column_name_list column_name_list;

	@Element
	private String kw_as = "as";

	@Element
	private subquery subquery = new subquery( );

	@Element
	private with_or_without_data with_or_without_data = new with_or_without_data( );

	public column_name_list getColumn_name_list( )
	{
		return column_name_list;
	}

	public void setColumn_name_list( column_name_list column_name_list )
	{
		this.column_name_list = column_name_list;
	}

	public subquery getSubquery( )
	{
		return subquery;
	}

	public with_or_without_data getWith_or_without_data( )
	{
		return with_or_without_data;
	}

}
