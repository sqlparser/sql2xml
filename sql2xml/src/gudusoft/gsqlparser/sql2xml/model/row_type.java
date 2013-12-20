
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class row_type
{

	@Element
	private String kw_row = "row";

	@Element
	private row_type_body row_type_body = new row_type_body( );

	public row_type_body getRow_type_body( )
	{
		return row_type_body;
	}

}
