
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class cross_join
{

	@Element(required = false)
	private table_reference table_reference;

	@Element(required = false)
	private table_factor table_factor;
}
