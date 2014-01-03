
package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;

public class set_clause_list
{

	@ElementList(entry = "set_clause", inline = true)
	private List<set_clause> set_clause = new ArrayList<set_clause>( );

	public List<set_clause> getSet_clause( )
	{
		return set_clause;
	}

}
