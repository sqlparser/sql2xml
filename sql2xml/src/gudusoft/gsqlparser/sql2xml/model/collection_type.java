
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class collection_type
{

	@Element(required = false)
	private array_type array_type;

	@Element(required = false)
	private multiset_type multiset_type;

	public array_type getArray_type( )
	{
		return array_type;
	}

	public void setArray_type( array_type array_type )
	{
		this.array_type = array_type;
	}

	public multiset_type getMultiset_type( )
	{
		return multiset_type;
	}

	public void setMultiset_type( multiset_type multiset_type )
	{
		this.multiset_type = multiset_type;
	}

}
