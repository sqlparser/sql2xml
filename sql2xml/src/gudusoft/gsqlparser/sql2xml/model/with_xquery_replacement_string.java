
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class with_xquery_replacement_string
{

	@Element
	private String kw_with = "with";

	@Element
	private xquery_replacement_string xquery_replacement_string = new xquery_replacement_string( );

	public xquery_replacement_string getXquery_replacement_string( )
	{
		return xquery_replacement_string;
	}

}
