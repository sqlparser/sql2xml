
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class references_specification
{

	@Element
	private String kw_references = "references";

	@Element
	private referenced_table_and_columns referenced_table_and_columns = new referenced_table_and_columns( );

	@Element(required = false)
	private match_type_clause match_type_clause;

	@Element(required = false)
	private referential_triggered_action referential_triggered_action;

	public match_type_clause getMatch_type_clause( )
	{
		return match_type_clause;
	}

	public void setMatch_type_clause( match_type_clause match_type_clause )
	{
		this.match_type_clause = match_type_clause;
	}

	public referential_triggered_action getReferential_triggered_action( )
	{
		return referential_triggered_action;
	}

	public void setReferential_triggered_action(
			referential_triggered_action referential_triggered_action )
	{
		this.referential_triggered_action = referential_triggered_action;
	}

	public referenced_table_and_columns getReferenced_table_and_columns( )
	{
		return referenced_table_and_columns;
	}

}
