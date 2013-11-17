
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class with_clause
{

	@Element
	private String kw_with;

	@Element(required = false)
	private String kw_recursive;

	@Element
	private with_list with_list;
}
