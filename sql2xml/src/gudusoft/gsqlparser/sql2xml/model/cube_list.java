
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class cube_list
{

	@Element
	private String kw_cube = "cube";

	@Element
	private ordinary_grouping_set_list ordinary_grouping_set_list = new ordinary_grouping_set_list( );

	public ordinary_grouping_set_list getOrdinary_grouping_set_list( )
	{
		return ordinary_grouping_set_list;
	}

}
