
package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;

public class when_operand_list
{

	@ElementList(entry = "when_operand", inline = true)
	private List<when_operand> when_operand = new ArrayList<when_operand>( );

	public List<when_operand> getWhen_operand( )
	{
		return when_operand;
	}

}
