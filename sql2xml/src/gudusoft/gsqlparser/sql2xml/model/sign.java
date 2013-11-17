package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;


public class sign
{
	@Element(required = false)
	private String plus_sign;
	
	@Element(required = false)
	private String minus_sign;
}
