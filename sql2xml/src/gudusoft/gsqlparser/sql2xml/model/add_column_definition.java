
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class add_column_definition
{

	@Element
	private String kw_add = "add";

	@Element(required = false)
	private String kw_column;

	@Element
	private column_definition column_definition = new column_definition( );

	public String getKw_column( )
	{
		return kw_column;
	}

	public void setKw_column( String kw_column )
	{
		this.kw_column = kw_column;
	}

	public column_definition getColumn_definition( )
	{
		return column_definition;
	}

}
