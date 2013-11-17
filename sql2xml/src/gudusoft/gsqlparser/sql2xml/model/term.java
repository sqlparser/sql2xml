package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class term
{
	@Element(required = false)
	private factor factor;

	@Element(required = false)
	private term_asterisk_factor term_asterisk_factor;

	@Element(required = false)
	private term_solidus_factor term_solidus_factor;
}
