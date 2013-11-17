
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class boolean_test
{

	@Element
	private boolean_primary boolean_primary;

	@Element(required = false)
	private is_not_truth_value is_not_truth_value;
}
