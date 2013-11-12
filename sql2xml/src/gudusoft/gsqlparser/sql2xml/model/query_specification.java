
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class query_specification
{

	@Element
	private String kw_select = "select";

	@Element(required = false)
	private set_quantifier set_quantifier;
	
	@Element
	private select_list select_list;
	
	@Element
	private table_expression table_expression;
}
