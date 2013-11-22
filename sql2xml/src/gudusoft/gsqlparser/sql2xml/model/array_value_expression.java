
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class array_value_expression
{

	@Element(required = false)
	private array_concatenation array_concatenation;

	@Element(required = false)
	private array_primary array_primary;

	public array_concatenation getArray_concatenation( )
	{
		return array_concatenation;
	}

	public void setArray_concatenation( array_concatenation array_concatenation )
	{
		this.array_concatenation = array_concatenation;
	}

	public array_primary getArray_primary( )
	{
		return array_primary;
	}

	public void setArray_primary( array_primary array_primary )
	{
		this.array_primary = array_primary;
	}

}
