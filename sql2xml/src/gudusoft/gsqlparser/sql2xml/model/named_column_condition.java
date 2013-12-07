
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class named_column_condition
{

	@Element
	private String kw_using = "using";

	@Element
	private join_column_list join_column_list = new join_column_list( );

	public join_column_list getJoin_column_list( )
	{
		return join_column_list;
	}

}
