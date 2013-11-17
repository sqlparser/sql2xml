
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class factor
{

	@Element(required = false)
	private sign sign;

	@Element
	private numeric_primary numeric_primary;

}
