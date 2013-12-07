
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class interval_term
{

	@Element(required = false)
	private interval_factor interval_factor;

	@Element(required = false)
	private interval_term_asterisk interval_term_asterisk;

	@Element(required = false)
	private interval_term_solidus interval_term_solidus;

	@Element(required = false)
	private term_asterisk_interval_factor term_asterisk_interval_factor;

	public interval_factor getInterval_factor( )
	{
		return interval_factor;
	}

	public void setInterval_factor( interval_factor interval_factor )
	{
		this.interval_factor = interval_factor;
	}

	public interval_term_asterisk getInterval_term_asterisk( )
	{
		return interval_term_asterisk;
	}

	public void setInterval_term_asterisk(
			interval_term_asterisk interval_term_asterisk )
	{
		this.interval_term_asterisk = interval_term_asterisk;
	}

	public interval_term_solidus getInterval_term_solidus( )
	{
		return interval_term_solidus;
	}

	public void setInterval_term_solidus(
			interval_term_solidus interval_term_solidus )
	{
		this.interval_term_solidus = interval_term_solidus;
	}

	public term_asterisk_interval_factor getTerm_asterisk_interval_factor( )
	{
		return term_asterisk_interval_factor;
	}

	public void setTerm_asterisk_interval_factor(
			term_asterisk_interval_factor term_asterisk_interval_factor )
	{
		this.term_asterisk_interval_factor = term_asterisk_interval_factor;
	}

}
