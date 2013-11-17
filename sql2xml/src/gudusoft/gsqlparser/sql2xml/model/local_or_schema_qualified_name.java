
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class local_or_schema_qualified_name
{

	@Element(required = false)
	private local_or_schema_qualifier local_or_schema_qualifier;

	@Element
	private qualified_identifier qualified_identifier;
}
