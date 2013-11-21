
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class local_or_schema_qualified_name
{

	@Element(required = false)
	private local_or_schema_qualifier local_or_schema_qualifier;

	@Element
	private qualified_identifier qualified_identifier = new qualified_identifier( );

	public local_or_schema_qualifier getLocal_or_schema_qualifier( )
	{
		return local_or_schema_qualifier;
	}

	public void setLocal_or_schema_qualifier(
			local_or_schema_qualifier local_or_schema_qualifier )
	{
		this.local_or_schema_qualifier = local_or_schema_qualifier;
	}

	public qualified_identifier getQualified_identifier( )
	{
		return qualified_identifier;
	}

}
