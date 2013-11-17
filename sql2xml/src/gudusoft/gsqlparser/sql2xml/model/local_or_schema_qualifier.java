
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class local_or_schema_qualifier
{

	@Element(required = false)
	private schema_name schema_name;

	@Element(required = false)
	private String local_qualifier;
}
