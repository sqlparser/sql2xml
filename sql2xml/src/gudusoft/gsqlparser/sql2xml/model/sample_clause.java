
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class sample_clause
{

	@Element
	private String kw_tablesample;

	@Element
	private sample_method sample_method;

	@Element
	private sample_percentage sample_percentage;

	@Element(required = false)
	private repeatable_clause repeatable_clause;
}
