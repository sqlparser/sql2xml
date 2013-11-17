
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class module_identifier_chain
{

	@Element
	private String kw_module;

	@Element
	private qualified_identifier qualified_identifier;

	@Element
	private column_name column_name;
}
