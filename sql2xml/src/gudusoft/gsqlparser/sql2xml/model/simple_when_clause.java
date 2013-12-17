
package gudusoft.gsqlparser.sql2xml.model;

import org.simpleframework.xml.Element;

public class simple_when_clause
{

	@Element
	private String kw_when = "when";

	@Element
	private when_operand_list when_operand_list = new when_operand_list( );

	@Element
	private String kw_then = "then";

	@Element
	private result result = new result( );

	public when_operand_list getWhen_operand_list( )
	{
		return when_operand_list;
	}

	public result getResult( )
	{
		return result;
	}

}
