
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class schema_qualified_name
{

	@Element(required = false)
	schema_name schema_name;

	@Element
	qualified_identifier qualified_identifier = new qualified_identifier( );

	public schema_name getSchema_name( )
	{
		return schema_name;
	}

	public void setSchema_name( schema_name schema_name )
	{
		this.schema_name = schema_name;
	}

	public qualified_identifier getQualified_identifier( )
	{
		return qualified_identifier;
	}

}
