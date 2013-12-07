
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class term_asterisk_interval_factor
{

	@Element
	private term term = new term( );

	@Element
	private interval_factor interval_factor = new interval_factor( );

	public term getTerm( )
	{
		return term;
	}

	public interval_factor getInterval_factor( )
	{
		return interval_factor;
	}

}
