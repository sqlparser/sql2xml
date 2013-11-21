
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class select_sublist
{

	@Element(required = false)
	private derived_column derived_column;

	@Element(required = false)
	private qualified_asterisk qualified_asterisk;

	public derived_column getDerived_column( )
	{
		return derived_column;
	}

	public void setDerived_column( derived_column derived_column )
	{
		this.derived_column = derived_column;
	}

	public qualified_asterisk getQualified_asterisk( )
	{
		return qualified_asterisk;
	}

	public void setQualified_asterisk( qualified_asterisk qualified_asterisk )
	{
		this.qualified_asterisk = qualified_asterisk;
	}

}
