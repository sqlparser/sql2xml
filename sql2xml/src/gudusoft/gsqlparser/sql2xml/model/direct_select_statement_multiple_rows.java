
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class direct_select_statement_multiple_rows
{

	@Element
	private cursor_specification cursor_specification;

	public cursor_specification getCursor_specification( )
	{
		return cursor_specification;
	}

	public void setCursor_specification(
			cursor_specification cursor_specification )
	{
		this.cursor_specification = cursor_specification;
	}
}
