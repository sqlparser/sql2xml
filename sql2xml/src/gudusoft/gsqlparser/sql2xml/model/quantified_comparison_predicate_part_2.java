
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class quantified_comparison_predicate_part_2
{

	@Element
	private comp_op comp_op = new comp_op( );

	@Element
	private quantifier quantifier = new quantifier( );

	@Element
	private table_subquery table_subquery = new table_subquery( );

	public comp_op getComp_op( )
	{
		return comp_op;
	}

	public quantifier getQuantifier( )
	{
		return quantifier;
	}

	public table_subquery getTable_subquery( )
	{
		return table_subquery;
	}

}
