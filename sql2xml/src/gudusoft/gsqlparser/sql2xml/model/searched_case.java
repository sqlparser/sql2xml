
package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

public class searched_case
{

	@Element
	private String kw_case = "case";

	@ElementList(entry = "searched_when_clause", inline = true)
	private List<searched_when_clause> searched_when_clause = new ArrayList<searched_when_clause>( );

	@Element(required = false)
	private else_clause else_clause;

	@Element
	private String kw_end = "end";

	public else_clause getElse_clause( )
	{
		return else_clause;
	}

	public void setElse_clause( else_clause else_clause )
	{
		this.else_clause = else_clause;
	}

	public List<searched_when_clause> getSearched_when_clause( )
	{
		return searched_when_clause;
	}

}
