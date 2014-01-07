
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class merge_update_specification
{

	@Element
	private String kw_update = "update";

	@Element
	private String kw_set = "set";

	@Element
	private set_clause_list set_clause_list = new set_clause_list( );

	public set_clause_list getSet_clause_list( )
	{
		return set_clause_list;
	}

}
