
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class comp_op
{

	@Element(required = false)
	private String equals_operator;

	@Element(required = false)
	private String not_equals_operator;

	@Element(required = false)
	private String less_than_operator;

	@Element(required = false)
	private String greater_than_operator;

	@Element(required = false)
	private String less_than_or_equals_operator;

	@Element(required = false)
	private String greater_than_or_equals_operator;
}
