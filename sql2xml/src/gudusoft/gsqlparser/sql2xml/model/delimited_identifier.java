
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class delimited_identifier
{

	@Element(name = "double_quote")
	private double_quote left_double_quote;

	@Element
	private String delimited_identifier_body;

	@Element(name = "double_quote")
	private double_quote right_double_quote;
}
