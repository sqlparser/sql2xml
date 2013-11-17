
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class local_qualified_name
{

	@Element(required = false)
	private String local_qualifier;

	@Element
	private qualified_identifier qualified_identifier;
}
