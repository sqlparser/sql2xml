
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class update_target
{

	@Element(required = false)
	private object_column object_column;

	@Element(required = false)
	private object_column_simple_value_specification object_column_simple_value_specification;

	public object_column getObject_column( )
	{
		return object_column;
	}

	public void setObject_column( object_column object_column )
	{
		this.object_column = object_column;
	}

	public object_column_simple_value_specification getObject_column_simple_value_specification( )
	{
		return object_column_simple_value_specification;
	}

	public void setObject_column_simple_value_specification(
			object_column_simple_value_specification object_column_simple_value_specification )
	{
		this.object_column_simple_value_specification = object_column_simple_value_specification;
	}

}
