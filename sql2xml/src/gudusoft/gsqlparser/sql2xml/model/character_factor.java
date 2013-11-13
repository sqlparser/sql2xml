
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class character_factor
{

	@Element
	private character_primary character_primary;

	@Element(required = false)
	private collate_clause collate_clause;
}
