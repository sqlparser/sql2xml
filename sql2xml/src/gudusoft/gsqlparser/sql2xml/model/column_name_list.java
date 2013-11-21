
package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;

public class column_name_list
{

	@ElementList(entry = "column_name", inline = true)
	private List<column_name> column_name = new ArrayList<column_name>( );

	public List<column_name> getColumn_name( )
	{
		return column_name;
	}

}
