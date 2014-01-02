
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class unique_specification_column_list
{

	@Element
	private unique_specification unique_specification = new unique_specification( );

	@Element
	private unique_column_list unique_column_list = new unique_column_list( );

	public unique_specification getUnique_specification( )
	{
		return unique_specification;
	}

	public unique_column_list getUnique_column_list( )
	{
		return unique_column_list;
	}

}
