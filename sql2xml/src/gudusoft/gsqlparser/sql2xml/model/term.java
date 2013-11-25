
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

	public factor getFactor( )
	{
		return factor;
	}

	public void setFactor( factor factor )
	{
		this.factor = factor;
	}

	public term_asterisk_factor getTerm_asterisk_factor( )
	{
		return term_asterisk_factor;
	}

	public void setTerm_asterisk_factor(
			term_asterisk_factor term_asterisk_factor )
	{
		this.term_asterisk_factor = term_asterisk_factor;
	}

	public term_solidus_factor getTerm_solidus_factor( )
	{
		return term_solidus_factor;
	}

	public void setTerm_solidus_factor( term_solidus_factor term_solidus_factor )
	{
		this.term_solidus_factor = term_solidus_factor;
	}

}
