
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class multiset_type
{

	@Element
	private data_type data_type = new data_type( );

	@Element
	private String kw_multiset = "multiset";

	public data_type getData_type( )
	{
		return data_type;
	}

}
