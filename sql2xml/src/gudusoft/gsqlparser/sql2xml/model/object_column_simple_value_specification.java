
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class object_column_simple_value_specification
{

	@Element
	private object_column object_column = new object_column( );

	@Element
	private simple_value_specification simple_value_specification = new simple_value_specification( );

	public object_column getObject_column( )
	{
		return object_column;
	}

	public simple_value_specification getSimple_value_specification( )
	{
		return simple_value_specification;
	}

}
