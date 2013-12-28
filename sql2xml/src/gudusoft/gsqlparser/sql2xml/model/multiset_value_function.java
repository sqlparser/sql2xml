
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class multiset_value_function
{

	@Element
	private multiset_set_function multiset_set_function = new multiset_set_function( );

	public multiset_set_function getMultiset_set_function( )
	{
		return multiset_set_function;
	}

}
