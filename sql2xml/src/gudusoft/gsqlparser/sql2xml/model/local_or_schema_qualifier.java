
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class local_or_schema_qualifier
{

	@Element(required = false)
	private schema_name schema_name;

	@Element(required = false)
	private String local_qualifier;

	public schema_name getSchema_name( )
	{
		return schema_name;
	}

	public void setSchema_name( schema_name schema_name )
	{
		this.schema_name = schema_name;
	}

	public String getLocal_qualifier( )
	{
		return local_qualifier;
	}

	public void setLocal_qualifier( String local_qualifier )
	{
		this.local_qualifier = local_qualifier;
	}

}
