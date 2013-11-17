
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class boolean_value_expression
{

	@Element(required = false)
	private boolean_term boolean_term;
	
	@Element(required = false)
	private boolean_value_expression_or boolean_value_expression_or;

}
