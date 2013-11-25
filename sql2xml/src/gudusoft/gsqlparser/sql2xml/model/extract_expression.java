
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class extract_expression
{

	@Element
	private String kw_extract = "extract";

	@Element
	private extract_field extract_field = new extract_field( );

	@Element
	private String kw_from = "from";

	@Element
	private extract_source extract_source = new extract_source( );

	public extract_field getExtract_field( )
	{
		return extract_field;
	}

	public extract_source getExtract_source( )
	{
		return extract_source;
	}

}
