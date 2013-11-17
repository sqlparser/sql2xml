package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class truth_value
{
	@Element(required = false)
	private String kw_true;
	
	@Element(required = false)
	private String kw_false;
	
	@Element(required = false)
	private String kw_unknown;
}
