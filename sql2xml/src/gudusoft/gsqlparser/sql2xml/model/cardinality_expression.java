
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class cardinality_expression
{

	@Element
	private String kw_cardinality = "cardinality";

	@Element
	private collection_value_expression collection_value_expression = new collection_value_expression( );

	public collection_value_expression getCollection_value_expression( )
	{
		return collection_value_expression;
	}

}
