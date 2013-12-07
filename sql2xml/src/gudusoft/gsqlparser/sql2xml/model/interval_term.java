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
	
}
