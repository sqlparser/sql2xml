
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class cast_specification
{

	@Element
	private String kw_cast = "cast";

	@Element
	private cast_operand cast_operand = new cast_operand( );

	@Element
	private String kw_as = "as";

	@Element
	private cast_target cast_target = new cast_target( );

	public cast_operand getCast_operand( )
	{
		return cast_operand;
	}

	public cast_target getCast_target( )
	{
		return cast_target;
	}

}
