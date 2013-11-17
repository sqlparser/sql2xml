
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class schema_name
{

	@Element(required = false)
	private catalog_name catalog_name;

	@Element
	private unqualified_schema_name unqualified_schema_name;
}
