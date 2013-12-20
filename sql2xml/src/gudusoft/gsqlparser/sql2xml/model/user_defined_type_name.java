
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class user_defined_type_name
{

	@Element(required = false)
	private schema_name schema_name;

	@Element
	private qualified_identifier qualified_identifier = new qualified_identifier( );

	
	public qualified_identifier getQualified_identifier( )
	{
		return qualified_identifier;
	}
	
}
