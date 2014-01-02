
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class unique_constraint_definition
{

	@Element(required = false)
	private unique_specification_column_list unique_specification_column_list;

	@Element(required = false)
	private unique_value unique_value;

	public unique_specification_column_list getUnique_specification_column_list( )
	{
		return unique_specification_column_list;
	}

	public void setUnique_specification_column_list(
			unique_specification_column_list unique_specification_column_list )
	{
		this.unique_specification_column_list = unique_specification_column_list;
	}

	public unique_value getUnique_value( )
	{
		return unique_value;
	}

	public void setUnique_value( unique_value unique_value )
	{
		this.unique_value = unique_value;
	}

}
