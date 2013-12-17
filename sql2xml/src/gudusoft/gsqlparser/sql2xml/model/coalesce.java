package gudusoft.gsqlparser.sql2xml.model;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;


public class coalesce
{
	@Element
	private String kw_coalesce = "coalesce";

	@ElementList(entry = "value_expression", inline = true)
	private List<value_expression> value_expression = new ArrayList<value_expression>( );

	public List<value_expression> getValue_expression( )
	{
		return value_expression;
	}
}
