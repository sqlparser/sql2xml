
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class module_identifier_chain
{

	@Element
	private String kw_module = "module";

	@Element
	private qualified_identifier qualified_identifier = new qualified_identifier( );

	@Element
	private column_name column_name = new column_name( );

	public qualified_identifier getQualified_identifier( )
	{
		return qualified_identifier;
	}

	public column_name getColumn_name( )
	{
		return column_name;
	}

}
