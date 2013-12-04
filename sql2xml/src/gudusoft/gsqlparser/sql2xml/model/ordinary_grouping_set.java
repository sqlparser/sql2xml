
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class ordinary_grouping_set
{

	@Element(required = false)
	private grouping_column_reference grouping_column_reference;

	@Element(required = false)
	private grouping_column_reference_list_with_paren grouping_column_reference_list_with_paren;

	public grouping_column_reference getGrouping_column_reference( )
	{
		return grouping_column_reference;
	}

	public void setGrouping_column_reference(
			grouping_column_reference grouping_column_reference )
	{
		this.grouping_column_reference = grouping_column_reference;
	}

	public grouping_column_reference_list_with_paren getGrouping_column_reference_list_with_paren( )
	{
		return grouping_column_reference_list_with_paren;
	}

	public void setGrouping_column_reference_list_with_paren(
			grouping_column_reference_list_with_paren grouping_column_reference_list_with_paren )
	{
		this.grouping_column_reference_list_with_paren = grouping_column_reference_list_with_paren;
	}

}
