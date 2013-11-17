
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class boolean_term
{

	@Element(required = false)
	private boolean_factor boolean_factor;
	
	@Element(required = false)
	private boolean_value_expression_and boolean_value_expression_and;
	
}
