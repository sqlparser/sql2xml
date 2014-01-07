
package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;

public class column_constraint_definition_list
{

	@ElementList(entry = "column_constraint_definition", inline = true)
	private List<column_constraint_definition> column_constraint_definition = new ArrayList<column_constraint_definition>( );

	public List<column_constraint_definition> getColumn_constraint_definition( )
	{
		return column_constraint_definition;
	}

}
