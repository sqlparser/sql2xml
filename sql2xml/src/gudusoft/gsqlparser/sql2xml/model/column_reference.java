
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class column_reference
{

	@Element(required = false)
	private basic_identifier_chain basic_identifier_chain;
	
	@Element(required = false)
	private module_identifier_chain module_identifier_chain;

}
