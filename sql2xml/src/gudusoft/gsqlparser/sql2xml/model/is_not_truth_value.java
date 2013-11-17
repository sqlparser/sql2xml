
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class is_not_truth_value
{

	@Element
	private String kw_is;

	@Element(required = false)
	private String kw_not;

	@Element
	private truth_value truth_value;
}
