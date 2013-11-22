
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class collection_derived_table
{

	@Element
	private String kw_unnest = "unnest";

	@Element
	private collection_value_expression collection_value_expression = new collection_value_expression( );

	@Element(required = false)
	private kw_with_ordinality kw_with_ordinality;

	public kw_with_ordinality getKw_with_ordinality( )
	{
		return kw_with_ordinality;
	}

	public void setKw_with_ordinality( kw_with_ordinality kw_with_ordinality )
	{
		this.kw_with_ordinality = kw_with_ordinality;
	}

	public collection_value_expression getCollection_value_expression( )
	{
		return collection_value_expression;
	}

}
