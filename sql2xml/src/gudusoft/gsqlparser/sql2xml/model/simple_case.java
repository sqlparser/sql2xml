
package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

public class simple_case
{

	@Element
	private String kw_case = "case";

	@Element
	private case_operand case_operand = new case_operand( );

	@ElementList(entry = "simple_when_clause", inline = true)
	private List<simple_when_clause> simple_when_clause = new ArrayList<simple_when_clause>( );

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

	public case_operand getCase_operand( )
	{
		return case_operand;
	}

	public List<simple_when_clause> getSimple_when_clause( )
	{
		return simple_when_clause;
	}

}
