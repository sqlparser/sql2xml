
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class term_solidus_factor
{

	@Element
	private term term = new term( );

	@Element
	private factor factor = new factor( );

	public term getTerm( )
	{
		return term;
	}

	public factor getFactor( )
	{
		return factor;
	}

}
