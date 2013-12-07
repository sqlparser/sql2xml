
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class interval_term_solidus
{

	@Element
	private interval_term_2 interval_term_2 = new interval_term_2( );

	@Element
	private factor factor = new factor( );

	public interval_term_2 getInterval_term_2( )
	{
		return interval_term_2;
	}

	public factor getFactor( )
	{
		return factor;
	}
}
