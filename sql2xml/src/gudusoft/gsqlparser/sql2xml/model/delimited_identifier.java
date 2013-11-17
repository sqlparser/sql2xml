
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class delimited_identifier
{

	@Element(name = "double_quote")
	private String left_double_quote;

	@Element
	private String delimited_identifier_body;

	@Element(name = "double_quote")
	private String right_double_quote;
}
