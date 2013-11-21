
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class column_reference
{

	@Element(required = false)
	private basic_identifier_chain basic_identifier_chain;

	@Element(required = false)
	private module_identifier_chain module_identifier_chain;

	public basic_identifier_chain getBasic_identifier_chain( )
	{
		return basic_identifier_chain;
	}

	public void setBasic_identifier_chain(
			basic_identifier_chain basic_identifier_chain )
	{
		this.basic_identifier_chain = basic_identifier_chain;
	}

	public module_identifier_chain getModule_identifier_chain( )
	{
		return module_identifier_chain;
	}

	public void setModule_identifier_chain(
			module_identifier_chain module_identifier_chain )
	{
		this.module_identifier_chain = module_identifier_chain;
	}

}
