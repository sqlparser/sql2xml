
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class else_clause
{

	@Element
	private String kw_else = "else";

	@Element
	private result result = new result( );

	public result getResult( )
	{
		return result;
	}

}
