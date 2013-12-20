
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class field_definition
{

	@Element
	private field_name field_name = new field_name( );

	@Element
	private data_type data_type = new data_type( );

	public field_name getField_name( )
	{
		return field_name;
	}

	public data_type getData_type( )
	{
		return data_type;
	}

}
