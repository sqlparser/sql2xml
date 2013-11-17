package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class query_expression_body_intersect
{
	@Element
	private query_term query_term ;
	
	@Element
	private String kw_intersect ;
	
	@Element(required = false)
	private set_quantifier set_quantifier;
	
	@Element(required = false)
	private corresponding_spec corresponding_spec;
	
	@Element
	private query_primary query_primary ;
}
