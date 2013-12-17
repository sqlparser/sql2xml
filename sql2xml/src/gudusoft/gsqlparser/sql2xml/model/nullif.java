
package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

public class nullif
{

	@Element
	private String kw_nullif = "nullif";

	@ElementList(entry = "value_expression", inline = true)
	private List<value_expression> value_expression = new ArrayList<value_expression>( );

	public List<value_expression> getValue_expression( )
	{
		return value_expression;
	}

}
