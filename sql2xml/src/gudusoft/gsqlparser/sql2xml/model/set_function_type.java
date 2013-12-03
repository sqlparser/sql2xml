
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class set_function_type
{

	@Element
	private computational_operation computational_operation = new computational_operation( );

	public computational_operation getComputational_operation( )
	{
		return computational_operation;
	}

}
