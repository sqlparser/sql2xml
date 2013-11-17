
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class boolean_factor
{

	@Element(required = false)
	private String kw_not;

	@Element
	private boolean_test boolean_test;
}
