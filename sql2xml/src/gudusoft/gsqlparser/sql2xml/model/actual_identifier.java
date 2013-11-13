
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class actual_identifier
{

	@Element(required = false)
	private String regular_identifier;

	@Element(required = false)
	private delimited_identifier delimited_identifier;

	@Element(required = false)
	private unicode_delimited_identifier unicode_delimited_identifier;
}
