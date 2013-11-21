
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class schema_name
{

	@Element(required = false)
	private catalog_name catalog_name;

	@Element
	private unqualified_schema_name unqualified_schema_name = new unqualified_schema_name( );

	public catalog_name getCatalog_name( )
	{
		return catalog_name;
	}

	public void setCatalog_name( catalog_name catalog_name )
	{
		this.catalog_name = catalog_name;
	}

	public unqualified_schema_name getUnqualified_schema_name( )
	{
		return unqualified_schema_name;
	}

}
