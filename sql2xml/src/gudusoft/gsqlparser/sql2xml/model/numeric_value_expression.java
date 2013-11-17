
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class numeric_value_expression
{

	@Element(required = false)
	private term term;

	@Element(required = false)
	private plus plus;

	@Element(required = false)
	private minus minus;
}
