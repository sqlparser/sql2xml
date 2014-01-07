
package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;

public class merge_operation_specification
{

	@ElementList(entry = "merge_when_clause", inline = true)
	private List<merge_when_clause> merge_when_clause = new ArrayList<merge_when_clause>( );

	public List<merge_when_clause> getMerge_when_clause( )
	{
		return merge_when_clause;
	}

}
